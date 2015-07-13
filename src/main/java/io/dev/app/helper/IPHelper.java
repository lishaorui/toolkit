package io.dev.app.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * desc: IP帮助类
 * 
 * @author lsr
 * @version 2014年6月5日
 */
@Component
public class IPHelper {
	private static final Logger logger = LoggerFactory.getLogger(IPHelper.class);

	public boolean isValidIPV4(String ip) {
		String ipV4Pattern = "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$";
		Pattern pattern = Pattern.compile(ipV4Pattern);
		Matcher matcher = pattern.matcher(ip);
		boolean isValid = matcher.matches();
		logger.debug("isValidIPV4:[{}-{}]", new Object[] { ip, isValid });
		return isValid;
	}
	
	/**
	 * 从请求中获取IP,IP链
	 * @param request
	 * @return
	 */
	public String getIP(HttpServletRequest request){
        String remoteHost = request.getRemoteHost();
        String remoteAddr = request.getRemoteAddr();
        String XForwardedFor = request.getHeader("X-Forwarded-For");
        String ProxyClientIP = request.getHeader("Proxy-Client-IP");
        String WLProxyClientIP = request.getHeader("WL-Proxy-Client-IP");
        logger.info("remote [host:{} -addr:{} -XForwardedFor:{} -ProxyClientIP:{} -WLProxyClientIP:{} ]", new Object[] {
                remoteHost, remoteAddr, XForwardedFor, ProxyClientIP, WLProxyClientIP });
        
        String remoteIP = request.getHeader("X-Forwarded-For");
        if (remoteIP == null || remoteIP.length() == 0 || "unknown".equalsIgnoreCase(remoteIP)) {
            remoteIP = request.getHeader("Proxy-Client-IP");
        }
        if (remoteIP == null || remoteIP.length() == 0 || "unknown".equalsIgnoreCase(remoteIP)) {
            remoteIP = request.getHeader("WL-Proxy-Client-IP");
        }
        if (remoteIP == null || remoteIP.length() == 0 || "unknown".equalsIgnoreCase(remoteIP)) {
            remoteIP = request.getRemoteAddr();
        }
        logger.info("remote [ip:{}]", remoteIP);
        
        return remoteIP;
	}

}
