package io.dev.app.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 上下文工具
 * 
 * @author lsr
 * @version 2013-4-2
 */
public class ContextHelper {
	private static Logger logger = LoggerFactory.getLogger(ContextHelper.class);

	/**
	 * 获取上下文路径
	 */
	public static String getContextPath() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String classPath = classLoader.getResource("").getPath();
		String contextPath = classPath.replace("WEB-INF/classes/", "");
		contextPath = contextPath.replace("%20", " ");
		contextPath = contextPath.substring(0, contextPath.lastIndexOf("/"));
		
		String os = System.getProperty("os.name");
		if (os.toLowerCase().contains("windows")) {
			contextPath = contextPath.replaceFirst("/", "");
		} else {
			// linux系统不删除第一个斜杠
		}
		logger.info("system path：[{}]", contextPath);
		return contextPath;
	}
	
	/**
	 * 获取类路径
	 * @return
	 */
	public static String getClassPath(){
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String classPath = classLoader.getResource("").getPath();
		logger.info("classPath :[{}]", classPath);
		return classPath;
	}
	
}
