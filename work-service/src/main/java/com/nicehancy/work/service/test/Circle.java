package com.nicehancy.work.service.test;

import com.nicehancy.work.service.api.model.test.Shap;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *     Circle形状
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/7/9 16:45
 **/
@Slf4j
public class Circle implements Shap{

    @Override
    public void draw() {
        log.info("Inside Circle::draw() method.");
    }
}