package io.dev.app.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * desc: 日期帮助类
 * 
 * @author lsr
 * @version 2014年5月14日
 */
public class DateHelper {
	private static final Logger logger = LoggerFactory.getLogger(DateHelper.class);

	public static int getDayNumber(Date oneday) {
		Calendar c = Calendar.getInstance();
		c.setTime(oneday);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	public static Date getDate(long timestamp) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(timestamp);
		return c.getTime();
	}

	public static Date getNow() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		return c.getTime();
	}

	public static String getNow(String pattern) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		return convertTo(c.getTimeInMillis(), pattern);
	}

	/**
	 * 分钟换算小时
	 * 
	 * @param minutes
	 * @return
	 */
	public static double convertToHours(long minutes) {
		double hours = minutes / 60.0;
		DecimalFormat format = new DecimalFormat("#.#");
		String formattedHours = format.format(hours);
		return Double.parseDouble(formattedHours);
	}

	public static Date convertTo(String date, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		Date targetDate = null;
		try {
			targetDate = df.parse(date);
		} catch (ParseException e) {
			logger.warn("#convertTo date:{}, pattern:{} caught exception:{}", date, pattern, e);
		}
		return targetDate;
	}

	public static String convertTo(Date date, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}

	public static String convertTo(long timestamp, String pattern) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(timestamp);

		return convertTo(c.getTime(), pattern);
	}

}
