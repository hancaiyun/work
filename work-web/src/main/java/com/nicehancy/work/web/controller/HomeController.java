package com.nicehancy.work.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

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

    /**
     * 主页面
     * @param response
     * @return
     */
    @RequestMapping(value = "/index")
    @ResponseBody
    public ModelAndView index(HttpServletResponse response) {
        response.addHeader("x-frame-options","SAMEORIGIN");
        ModelAndView mode = new ModelAndView();
        mode.setViewName("index");
        return mode;
    }

    /**
     * 欢迎页
     * @param response
     * @return
     */
    @RequestMapping(value = "/welcome")
    @ResponseBody
    public ModelAndView welcome(HttpServletResponse response){
        response.addHeader("x-frame-options","SAMEORIGIN");
        ModelAndView mode = new ModelAndView();
        mode.setViewName("welcome");
        return mode;
    }
}
