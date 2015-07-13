package io.dev.app.server;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * desc: 应用服务器
 * @author lsr
 * @version 2014年5月21日
 */
@Controller
public class AppServer {
	private static final Logger logger = LoggerFactory.getLogger(AppServer.class);
	
	@RequestMapping(value="/back", method = RequestMethod.GET, produces="text/plain")
	@ResponseBody
	public String back(HttpServletRequest request){
		return "error";
	}
	
	@RequestMapping(value="/back", method = RequestMethod.POST, produces="text/plain")
	@ResponseBody
	public String back(HttpServletRequest request, @RequestParam("msg") String  msg){
		// 处理接收到的信息
		logger.info("app server received msg :[{}]", msg);
		return "success";
	}

}
