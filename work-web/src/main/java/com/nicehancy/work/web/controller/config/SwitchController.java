package com.nicehancy.work.web.controller.config;

import com.nicehancy.work.web.controller.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *  系统配置controller
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/26 10:28
 **/
@Slf4j
@Controller
@RequestMapping("/config")
public class SwitchController extends BaseController {

    @RequestMapping(value = "/switch")
    @ResponseBody
    public ModelAndView getPage(){

        ModelAndView mode = new ModelAndView();
        mode.setViewName("switch");
        return mode;
    }

}
