package com.nicehancy.work.web.controller.config;

import com.nicehancy.work.service.api.model.base.Result;
import com.nicehancy.work.service.config.DataSourceSwitchServiceImpl;
import com.nicehancy.work.web.controller.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

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

    @Autowired
    private DataSourceSwitchServiceImpl dataSourceSwitchService;

    /**
     * 开关页面
     * @return     页面视图
     */
    @RequestMapping(value = "/switch")
    @ResponseBody
    public ModelAndView getPage(){

        ModelAndView mode = new ModelAndView();
        mode.setViewName("switch");
        return mode;
    }

    /**
     * 数据源切换
     * @param request   请求参数
     * @return
     */
    @RequestMapping(value = "/switchCheck")
    @ResponseBody
    public ModelMap switchCheck(HttpServletRequest request){

        String traceLogId = UUID.randomUUID().toString();
        MDC.put("TRACE_LOG_ID", traceLogId);
        String datasource = this.getParameters(request).get("datasource");
        log.info("SwitchController switchCheck request PARAM: datasource={}, traceLogId={}", datasource, traceLogId);

        Result<Boolean> result =  dataSourceSwitchService.switchDataSource(datasource, traceLogId);

        return this.processSuccessJSON(result);
    }
}
