package com.nicehancy.work.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *     跨域过滤器
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/17 14:34
 **/
@WebFilter
public class FrameFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        //必须
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //实际设置，允许跨域
        response.setHeader("x-frame-options", "SAMEORIGIN");
        //调用下一个过滤器
        filterChain.doFilter(request, response);
    }
}