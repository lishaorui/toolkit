package io.dev.app.helper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * desc: HTTP连接帮助类
 * 
 * @author lsr
 * @version 2014年5月14日
 */
@Component
@Scope(value = "prototype")
public class HttpHelper {
	private static final Logger logger = LoggerFactory.getLogger(HttpHelper.class);
	private CloseableHttpClient httpclient;
	private CloseableHttpResponse response;
	private RequestConfig requestConfig;

	@PostConstruct
	public void init() {
		logger.info("httpclient init...");
		httpclient = HttpClients.createDefault();
		// 连接超时5秒
		// 读超时5秒
		requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();

	}

	public String get(List<NameValuePair> params, String url) throws Exception {
		// 使用http post请求，传递签名参数，由应用服务器去验证
		HttpGet httpget = new HttpGet(url);
		httpget.setConfig(requestConfig);
		// 将POST参数以UTF-8编码并包装成表单实体对象
		try {
			String str = EntityUtils.toString(new UrlEncodedFormEntity(params, "UTF-8"));
			logger.info("http get request:[url:{},params:{}]", new Object[] { url, str });
			httpget.setURI(new URI(httpget.getURI().toString() + "?" + str));
			response = httpclient.execute(httpget);
			// 获取响应实体 
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			logger.info("http get response:[{}]", result);
			return result;
		} catch (ParseException | IOException | URISyntaxException e) {
			logger.info("http get request caught excception:{}", e.getMessage());
			throw new Exception();
		}
	}

	public String post(List<NameValuePair> params, String url) throws Exception {
		// 使用http post请求，传递签名参数，由应用服务器去验证
		HttpPost httppost = new HttpPost(url);
		httppost.setConfig(requestConfig);
		try {
			logger.info("http post request:[url:{},params:{}]", new Object[] { url, params });
			// 将POST参数以UTF-8编码并包装成表单实体对象
			httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			response = httpclient.execute(httppost);
			// 获取响应实体 
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			logger.info("http post response:[{}]", result);
			return result;
		} catch (Exception e) {
			logger.info("http post request caught excception:{}", e.getMessage());
			throw new Exception();
		}
	}

	@PreDestroy
	public void close() throws Exception {
		try {
			if (httpclient != null)
				httpclient.close();
		} catch (IOException e) {
			logger.info("httpclient close exception:{}", e.getMessage());
			throw new Exception();
		}
	}
}
