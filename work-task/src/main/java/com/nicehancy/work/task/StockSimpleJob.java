package com.nicehancy.work.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *     作业
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/15 17:02
 **/
@Slf4j
public class StockSimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        log.info(String.format("------Thread ID: %s, 任务总片数: %s, " +
                        "当前分片项: %s.当前参数: %s,"+
                        "当前任务名称: %s.当前任务参数: %s"
                ,
                Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(),
                shardingContext.getJobParameter()
        ));
    }
}