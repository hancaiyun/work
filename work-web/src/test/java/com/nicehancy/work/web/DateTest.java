package com.nicehancy.work.web;

import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *     日期测试
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/6/12 9:05
 **/
@Slf4j
public class DateTest extends BaseSpringTest {

    @Test
    public void test(){

        Date date = new Date();
        Date theDayBefor = getTheDateBefore(date);
        log.info("{}", theDayBefor);
    }

    public Date getTheDateBefore(Date date) {

        int month = date.getMonth() + 1;
        int day = date.getDay()  - 1;
        int year = date.getYear() + 1900;
        String dateTime = year + "-" + month + "-" + day;
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        Date theDayBefore = null;
        try {
            theDayBefore = sim.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return theDayBefore;
    }
}