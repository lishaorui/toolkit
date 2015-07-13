package io.dev.app.helper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * desc: 结果生成器
 * @author lsr
 * @version 2014年5月23日
 */
@Component
public class ResultGenerator {
	
	public Map<String, Object> generateResult(int code, String message){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", code);
		result.put("resultMessage", message);
		return result;
	}
	
	public Map<String, Object> generateResult(int code, String message, Object data){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", code);
		result.put("resultMessage", message);
		result.put("data", data);
		return result;
	}
}
