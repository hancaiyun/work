package com.nicehancy.work.web.controller.user;

import com.nicehancy.work.web.controller.base.BaseController;
import com.nicehancy.work.service.api.model.user.UserInfoDTO;
import com.nicehancy.work.service.user.UserInfoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * 用户管理controller
 * <p>
 *     1、登陆
 *     2、注册
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/3/14 14:50
 **/
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserInfoServiceImpl userInfoService;

    /**
     * 用户管理页面
     * @return     页面视图
     */
    @RequestMapping(value = "/page")
    @ResponseBody
    public ModelAndView getPage(){

        ModelAndView mode = new ModelAndView();
        mode.setViewName("user-list");
        return mode;
    }

    /**
     * 用户信息查询
     * @param request               请求参数
     * @return                      查询结果
     * @throws                      IOException
     */
    @RequestMapping("/queryUserInfo")
    public ModelMap queryUserInfo(HttpServletRequest request) throws IOException {

        String traceLogId = UUID.randomUUID().toString();
        MDC.put("TRACE_LOG_ID", traceLogId);
        String userNo = this.getParameters(request).get("userNo");

        log.info("UserController queryUserInfo request PARAM: userNo={}, traceLogId={}", userNo, traceLogId);
        UserInfoDTO userInfoDTO = userInfoService.queryUserInfo(userNo, traceLogId);
        log.info("UserController queryUserInfo RESULT: {}",userInfoDTO);

        return this.processSuccessJSON(userInfoDTO);
    }

    /**
     * 用户信息分页查询
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/list")
    @ResponseBody
    public ModelMap pageQuery(HttpServletRequest request) throws IOException {

        String traceLogId = UUID.randomUUID().toString();
        MDC.put("TRACE_LOG_ID", traceLogId);
        String currentPage = this.getParameters(request).get("currentPage");
        String pageSize = this.getParameters(request).get("pageSize");
        String userNo = this.getParameters(request).get("userNo");

        log.info("UserController queryUserInfo request PARAM: currentPage={}, pageSize={},  userNo={}, traceLogId={}",
                currentPage, pageSize, userNo, traceLogId);


        //log.info("UserController queryUserInfo RESULT: {}",userInfoDTO);

        return processSuccessJSON("");
    }
}
