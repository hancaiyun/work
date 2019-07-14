package com.nicehancy.work.web.utils;

import com.nicehancy.work.common.utils.RedisUtil;
import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;

import java.util.List;

/**
 * <p>
 *     redis GEO测试类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/7/10 15:32
 **/
@Slf4j
public class RedisUtilTest extends BaseSpringTest {

    /**
     * 新增坐标测试
     */
    @Test
    public void geoAddTest(){

        double longitude = 121.485811;//121.503329;//121.490433;
        double latitude = 31.248003;//31.238484;//31.245358;
        String key = "MERCHANT_COORDINATE_SET";
        String memberName = "3178002075450473";
        GeoCoordinate geoCoordinate = new GeoCoordinate(longitude, latitude);

        RedisUtil.geoadd(key, geoCoordinate, memberName);
    }

    /**
     * 距离计算测试
     */
    @Test
    public void getDistanceTest(){

        String key = "MERCHANT_COORDINATE_SET";
        String member1 = "3178002075450473";
        String member2 = "18672056943";

        double dis = RedisUtil.geoDist(key, member1, member2, GeoUnit.M);

        log.info("距离:{}m", Math.round(dis));
    }

    /**
     * 附近范围member获取
     */
    @Test
    public void getNearByTest(){

        String key = "MERCHANT_COORDINATE_SET";

        double longitude = 121.485811;//121.503329;//121.490433;
        double latitude = 31.248003;//31.238484;//31.245358;
        GeoCoordinate geoCoordinate = new GeoCoordinate(longitude, latitude);

        double radius = 5000;
        List<GeoRadiusResponse> responses =  RedisUtil.geoRadius(key, geoCoordinate, radius);
        for(GeoRadiusResponse geoRadiusResponse : responses){
            log.info("附近范围内坐标，经度:{}，维度:{}, member:{}", geoRadiusResponse.getCoordinate().getLongitude(),
                    geoRadiusResponse.getCoordinate().getLatitude(), geoRadiusResponse.getMemberByString());
        }
    }

    /**
     * 获取member的hash值
     */
    @Test
    public void getGeohash(){

        String key = "MERCHANT_COORDINATE_SET";
        String member = "18672056943";
        List<String> geohash= RedisUtil.geohash(key, member);
        log.info("打印结果：{}", geohash);
    }
}