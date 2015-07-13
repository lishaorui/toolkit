package io.dev.app.exception;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import io.dev.app.helper.ResultGenerator;

/**
 * desc: 全局异常处理器
 * @author lsr
 * @version 2014年5月28日
 */
@ControllerAdvice
public class GlobalExceptionController {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);
	@Autowired
	private ResultGenerator resultGenerator;
	
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String, Object> handleException(Exception se){
		logger.warn("caught exception:", se);
		return resultGenerator.generateResult(-1, "系统异常");
	}
	
	@ExceptionHandler(SystemException.class)
	@ResponseBody
	public Map<String, Object> handleSystemException(SystemException se){
		logger.warn("caught system exception:", se);
		return resultGenerator.generateResult(se.getResultCode(), se.getResultMessage());
	}
	
}
