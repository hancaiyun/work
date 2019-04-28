package com.nicehancy.work.web;

import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <p>
 *     HashMap测试类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/25 16:21
 **/
@Slf4j
public class HashMapTest extends BaseSpringTest {

    /**
     * 遍历hashmap
     */
    @Test
    public void hashMapTest(){

        Map<String, String> map = new HashMap<>();
        map.put("1", "valueA");
        map.put("2", "valueB");
        map.put("3", "valueC");

        //第一种：二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        for (String key : map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }

        //第二种：迭代器
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }

    }
}