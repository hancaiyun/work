package com.nicehancy.work.service.test;

import com.nicehancy.work.service.api.model.test.Shap;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *     Rectangle形状
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/7/9 16:43
 **/
@Slf4j
public class Rectangle implements Shap {

    @Override
    public void draw() {
        log.info("Inside Rectangle::draw() method.");
    }
}