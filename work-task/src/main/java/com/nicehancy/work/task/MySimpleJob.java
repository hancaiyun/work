package com.nicehancy.work.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *     simplejob
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/26 10:42
 **/
@Component
@Slf4j
public class MySimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(sdf.format(new Date())+"*********每5秒执行一次");
    }
}