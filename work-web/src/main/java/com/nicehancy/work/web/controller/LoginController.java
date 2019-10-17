package com.nicehancy.work.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义登陆页面
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/10/15 9:10
 **/
@Controller
public class LoginController {

    /**
     * 登录页
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ModelAndView login(){
        ModelAndView mode = new ModelAndView();
        mode.setViewName("login");
        return mode;
    }
}
