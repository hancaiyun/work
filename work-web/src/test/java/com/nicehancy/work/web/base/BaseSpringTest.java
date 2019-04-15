package com.nicehancy.work.web.base;

import com.nicehancy.work.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 *     测试父类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/3/13 19:52
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
public class BaseSpringTest{
}
