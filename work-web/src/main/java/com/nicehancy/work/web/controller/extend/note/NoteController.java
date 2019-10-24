package com.nicehancy.work.web.controller.extend.note;

import com.nicehancy.work.service.api.model.base.Result;
import com.nicehancy.work.service.extend.NoteServiceImpl;
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
 * 笔记管理controller
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/10/14 12:23
 **/
@Slf4j
@Controller
@RequestMapping("/note")
public class NoteController extends BaseController {

    @Autowired
    private NoteServiceImpl noteService;

    /**
     * 笔记页面
     * @return     页面视图
     */
    @RequestMapping(value = "/page")
    @ResponseBody
    public ModelAndView getPage(){

        ModelAndView mode = new ModelAndView();
        mode.setViewName("note-index");
        return mode;
    }

    /**
     * 笔记查询
     * @return     数据
     */
    @RequestMapping(value = "/query")
    @ResponseBody
    public ModelMap query(HttpServletRequest request){

        String traceLogId = UUID.randomUUID().toString();
        MDC.put("TRACE_LOG_ID", traceLogId);
        String id = this.getParameters(request).get("id");
        log.info("NoteController query request PARAM: id={}, traceLogId={}", id, traceLogId);

        Result<String> result =  noteService.queryById(id, traceLogId);

        return this.processSuccessJSON(result);
    }

    /**
     * 笔记保存
     * @return     处理结果
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public ModelMap save(HttpServletRequest request){

        String traceLogId = UUID.randomUUID().toString();
        MDC.put("TRACE_LOG_ID", traceLogId);
        //目录id
        String id = this.getParameters(request).get("id");
        //笔记内容
        String content = this.getParameters(request).get("content");
        log.info("NoteController save request PARAM: id={}, traceLogId={}", id, traceLogId);

        Result<Boolean> result =  noteService.save(id, traceLogId, content);
        if(result.getResult()) {
            return this.processSuccessJSON(result);
        }else{
            return this.processSuccessJSON(result.getErrorMsg());
        }
    }

}
