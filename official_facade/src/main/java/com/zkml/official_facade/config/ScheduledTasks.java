package com.zkml.official_facade.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by fanghui on 2019/7/19.
 */
/*@Component*/
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("方会，帅吗？",dateFormat.format(new Date()));
        try {
            TimeUnit.SECONDS.sleep(2);
        log.info("**************************************************************************");
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        log.info("您好！方帅！",dateFormat.format(new Date()));
    }
}
