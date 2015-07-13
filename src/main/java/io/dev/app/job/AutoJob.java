package io.dev.app.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * @author lisr
 * @since 2015年2月16日
 */
@Component
public class AutoJob {
    private static final Logger logger = LoggerFactory.getLogger(AutoJob.class);
    
    // 每日6:05执行
    @Scheduled(cron = "0 5 6 * * ?")
    public void process(){
        logger.info("#process begins....");
        logger.info("#process ends....");
    }
}
