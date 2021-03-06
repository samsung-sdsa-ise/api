package com.samsung.api.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CORSInterceptor extends HandlerInterceptorAdapter 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(CORSInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception 
    {
    	LOGGER.info(" - CORSInterceptor - ");
    	
        response.addHeader("Access-Control-Allow-Origin", "*");
        return true;
    }
}