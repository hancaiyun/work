package com.nicehancy.work.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 主页面
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/19 14:21
 **/
@Slf4j
@Controller
public class HomeController {

    @RequestMapping(value = "/index")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView mode = new ModelAndView();
        mode.setViewName("index");
        return mode;
    }
}
