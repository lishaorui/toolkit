package io.dev.app.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * desc: 位置帮助类
 * @author lsr
 * @version 2014年5月19日
 */
@Component
public class LocationHelper {
	private static final Logger logger = LoggerFactory.getLogger(LocationHelper.class);
	
	private static final double EARTH_RADIUS = 6378137;  // 地球半径，单位米
	
	/**
	 * 计算两点间距离，单位为米
	 */
	public double getDistance(double currentLng, double currentLat, double targetLng, double targetLat) {
		double radCurrentLat = rad(currentLat);
		double radTargetLat = rad(targetLat);
		double a = radCurrentLat - radTargetLat;
		double b = rad(currentLng) - rad(targetLng);
		double s = 2 * Math.asin(
					Math.sqrt(
							Math.pow(Math.sin(a / 2), 2) 
							+ Math.cos(radCurrentLat) * Math.cos(radTargetLat) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		logger.info("两点之间的距离[{},{}]-[{},{}]={}", new Object[]{currentLng, currentLat, targetLng, targetLat, s});
		return s;
	}
	
	public boolean isNear(double currentLng, double currentLat, double targetLng, double targetLat, double areaRadius){
		return getDistance(currentLng, currentLat, targetLng, targetLat) <= areaRadius;
	}
	
	private double rad(double d) {
		return d * Math.PI / 180.0;
	}
	
}
