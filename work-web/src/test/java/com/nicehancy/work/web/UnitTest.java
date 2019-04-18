package com.nicehancy.work.web;

import com.nicehancy.work.common.utils.FileUtil;
import com.nicehancy.work.common.utils.RegularValidatorUtil;
import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <p>
 *     单元、自定义测试
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/9 12:10
 **/
@Slf4j
public class UnitTest extends BaseSpringTest {

    static int arr[] = new int[10];

    @Test
    public void test(){
        log.info("{}",arr[1]);
    }

    /**
     * 加密
     */
    @Test
    public void encoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //加密
        String encode = bCryptPasswordEncoder.encode("123456");
        log.info("密文：{}", encode);
        log.info("数据库存储格式为:{}","{bcrypt}" + encode);
    }

    /**
     * 邮箱验证测试
     */
    @Test
    public void isEmailTest(){
        String str = "nicehancy@yeah.net";
        log.info("验证结果：{}", RegularValidatorUtil.isEmail(str));
    }

    @Test
    public void fileTest(){

        FileUtil.createFile();
    }
}
