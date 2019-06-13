package com.nicehancy.work.task;

import ch.qos.logback.core.util.TimeUtil;
import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 *     任务监听器
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/6/13 10:25
 **/
public class MyElasticJobListener implements ElasticJobListener {

    private static final Logger logger = LoggerFactory.getLogger(MyElasticJobListener.class);

    private long beginTime = 0;
    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        beginTime = System.currentTimeMillis();

        logger.info("===>{} JOB BEGIN TIME: {} <===",shardingContexts.getJobName());
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {

        long endTime = System.currentTimeMillis();
        logger.info("===>{} JOB END TIME: {},TOTAL CAST: {} <===",shardingContexts.getJobName(), endTime - beginTime);
    }
}