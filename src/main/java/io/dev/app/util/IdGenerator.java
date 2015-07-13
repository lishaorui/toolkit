package io.dev.app.util;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * desc: ID生成器
 * @author lsr
 * @version 2014年6月4日
 */
public class IdGenerator {
	private static final Logger logger = LoggerFactory.getLogger(IdGenerator.class);
	
	/**
	 * 生成UUID，去除了<code>-</code>的
	 * @return
	 */
	public static synchronized String generateUUID(){
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		logger.debug("generate uuid:{}", uuid);
		return uuid;
	}
	
	/**
	 * 生成普通的时间串ID
	 * @return
	 */
	public static synchronized String generateID(){
		String id = DateHelper.convertTo(new Date(), "yyyyMMddHHmmssSSS");
		logger.debug("generate id:{}", id);
		return id;
	}
	
	public static String generateCaptcha(){
		String captcha = RandomStringUtils.random(4, "0123456789");;
		logger.debug("generate captcha:{}", captcha);
		return captcha;
	}
	
}
