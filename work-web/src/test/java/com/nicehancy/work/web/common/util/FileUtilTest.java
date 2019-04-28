package com.nicehancy.work.web.common.util;

import com.nicehancy.work.common.utils.FileUtil;
import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * <p>
 *     文件工具测试类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/23 14:47
 **/
@Slf4j
public class FileUtilTest extends BaseSpringTest {

    @Test
    public void PDFTest(){

        FileUtil.createPDF("/data/dataTemp/");
    }
}