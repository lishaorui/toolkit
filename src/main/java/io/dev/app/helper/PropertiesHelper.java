package io.dev.app.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 配置信息帮助类
 * 
 */
@Component
public class PropertiesHelper {

    private static Logger logger = LoggerFactory.getLogger(PropertiesHelper.class);

    private Map<String, Object> map = new HashMap<>();

    @PostConstruct
    public void init() {
        try {
            // 要加载的配置文件
            String[] props = new String[]{
                    "upgrade.properties",
                    "server.properties"
            };
            
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            for(String prop : props){
                Properties properties = new Properties();
                properties.load(loader.getResourceAsStream(prop));
                for(Map.Entry<Object, Object> entry : properties.entrySet())
                    map.put(entry.getKey().toString(), entry.getValue());
            }
            logger.info("load config:", map);
        } catch (Exception e) {
            logger.error("Can't read the properties file. {}", e.getMessage());
        }
    }

    /**
     * 获取指定Key的配置项的值.
     * 
     * @param key
     *            配置项键值.
     * @return 配置项的值
     */
    public String getValue(String key) {
    	Object value = map.get(key);
        return value == null ? "" : value.toString();
    }
    
    public Object get(String key) {
        return map.get(key);
    }
}
