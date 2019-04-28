package com.nicehancy.work.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/26 10:42
 **/
@Component
@Slf4j
public class ScheduledTasks  {
    // cron接受cron表达式，根据cron表达式确定定时规则
    @Scheduled(cron="0/5 * * * * ? ") //每5秒执行一次
    public void testCron() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(sdf.format(new Date())+"*********每5秒执行一次");
    }
}