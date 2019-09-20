package com.nicehancy.work.web.controller.base;

import com.nicehancy.work.web.view.ResultConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *     spring的基础控制器
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/11 19:56
 **/
@Slf4j
public abstract class AbstractController {

    /**
     * 处理返回结果
     *
     * @param code              状态码
     * @param view              视图
     * @param params            请求参数
     * @param message           描述
     * @param errors            错误
     */
    protected ModelAndView processFailure(String code, String view, Object params, String message, Object errors) {
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject(ResultConstants.RESULT_CODE_NAME, code);
        modelAndView.addObject(ResultConstants.RESULT_PARAM_NAME, params);
        modelAndView.addObject(ResultConstants.RESULT_MESSAGE_NAME, message);
        modelAndView.addObject(ResultConstants.RESULT_ERRORS_NAME, errors);
        return modelAndView;
    }

    /**
     * 处理返回结果
     *
     * @param result    结果
     */
    protected ModelMap processSuccessJSON(Object result) {
        ModelMap modelMap = new ModelMap();
        modelMap.put(ResultConstants.RESULT_CODE_NAME, ResultConstants.SUCCESS_CODE);
        modelMap.put(ResultConstants.RESULT_DATA_NAME, result);
        return modelMap;
    }

    /**
     * 处理返回结果
     *
     * @param result    结果
     */
    protected ModelMap processSuccessJSON(Object result, String message) {
        ModelMap modelMap = new ModelMap();
        modelMap.put(ResultConstants.RESULT_CODE_NAME, ResultConstants.SUCCESS_CODE);
        modelMap.put(ResultConstants.RESULT_DATA_NAME, result);
        modelMap.put(ResultConstants.RESULT_MESSAGE_NAME, message);
        return modelMap;
    }

}
