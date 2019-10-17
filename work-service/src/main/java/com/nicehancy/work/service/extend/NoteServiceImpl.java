package com.nicehancy.work.service.extend;

import com.nicehancy.work.biz.extend.NoteBiz;
import com.nicehancy.work.service.api.extend.NoteDTO;
import com.nicehancy.work.service.api.model.base.Result;
import com.nicehancy.work.service.convert.NoteDTOConvert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 笔记操作接口
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/10/16 15:19
 **/
@Slf4j
@Service
public class NoteServiceImpl {

    @Autowired
    private NoteBiz noteBiz;

    /**
     * 笔记查询
     * @param documentId        documentId
     * @param traceLogId        日志ID
     * @return
     */
    //@Override
    public Result<String> queryById(String documentId, String traceLogId) {

        Result<String> result = new Result<>();
        try{
            log.info("call NoteServiceImpl queryById param: documentId={},traceLogId={}", documentId, traceLogId);
            //业务处理
            NoteDTO noteDTO = NoteDTOConvert.getDTOByBO(noteBiz.queryById(documentId));
            if(null != noteDTO){
                result.setResult(noteDTO.getContent());
            }
            log.info("call NoteServiceImpl queryById result: {}", result);
        }catch (Exception e){
            log.error("call NoteServiceImpl queryById failed, message：e={}", e);
            result.setErrorMsg(e.getMessage());
        }
        return result;
    }

    /**
     * 笔记保存
     * @param documentId          documentId
     * @param traceLogId          日志id
     * @param content             内容
     * @return                    保存结果
     */
    public Result<Boolean> save(String documentId, String traceLogId, String content) {

        Result<Boolean> result = new Result<>();
        try{
            log.info("call NoteServiceImpl save param: documentId={}, content={}, traceLogId={}", documentId,
                    content, traceLogId);
            //业务处理
            boolean isDone = noteBiz.save(documentId, content);
            result.setResult(isDone);
            log.info("call NoteServiceImpl save result: {}", result);
        }catch (Exception e){
            log.error("call NoteServiceImpl save failed, message：e={}", e);
            result.setErrorMsg(e.getMessage());
        }
        return result;
    }
}
