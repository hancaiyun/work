package com.nicehancy.work.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>
 *     simpleJob
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/16 18:25
 **/
@Slf4j
@Component
public class MyElasticJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
       log.info(String.format("------Thread ID: %s, 任务总片数: %s, "
                        + "当前分片项: %s.当前参数: %s,"
                        + "当前任务名称: %s.当前任务参数: %s",
                Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(),
                shardingContext.getJobParameter()));
        switch (shardingContext.getShardingItem()) {
            case 0:
                System.out.println("do something by sharding item 0");
                break;
            case 1:
                System.out.println("do something by sharding item 1");
                break;
            case 2:
                System.out.println("do something by sharding item 2");
                break;
            default:
                break;
        }
    }


}