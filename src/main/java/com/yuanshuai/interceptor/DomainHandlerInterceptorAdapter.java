package com.yuanshuai.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/9/26
 */
public class DomainHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    private Logger LOGGER = LoggerFactory.getLogger(DomainHandlerInterceptorAdapter.class);

    public static final String REQUEST_HEADER_ORIGIN = "Origin";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String Origin = request.getHeader(REQUEST_HEADER_ORIGIN);

        LOGGER.info("Origin------->{}", Origin);

        return super.preHandle(request, response, handler);
    }
}
