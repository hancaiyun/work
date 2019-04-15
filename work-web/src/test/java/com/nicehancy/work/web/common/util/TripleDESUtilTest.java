package com.nicehancy.work.web.common.util;

import com.nicehancy.work.common.utils.TripleDESUtil;
import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * <p>
 *     3DES加密测试类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/12 9:45
 **/
@Slf4j
public class TripleDESUtilTest extends BaseSpringTest {

    @Test
    public void encryptTest(){
        try {
            log.info(TripleDESUtil.encrypt("hancaiyun"));
            log.info(TripleDESUtil.decrypt("352F2B6B633273474A4F2B334931634C5A5A445234673D3D"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
