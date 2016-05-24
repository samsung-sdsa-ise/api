/**
 * Copyright (c) 2016 Samsung SDSA. All Rights Reserved.
 */
package com.samsung.api.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.google.gson.Gson;
import com.samsung.api.common.constant.CommonValue;
import com.samsung.api.common.web.JsonResponse;
import com.samsung.api.vo.Meta;

public class GlobalExceptionHandler 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String APP_JSON_CHARSET_UTF_8 = "application/json; charset=UTF-8";
	
	@Autowired
	private MessageSourceAccessor messageSourceAccessor;
	
	@ExceptionHandler(value = Exception.class)
	public Object handleException(Exception e) 
	{
		LOGGER.info("[GlobalExceptionHandler.handleException]");
		
		Meta meta = new Meta();
//		meta.setMessage(messageSourceAccessor.getMessage(CommonValue.Message.Error.COMMON));
		meta.setMessage("Not okay.");
		meta.setSuccess(false);
		
//		if (AuthManager.getLoginUser() == null) {
//			meta.setSession(false);
//		} else {
//			meta.setSession(true);
//		}
		
		String message = "[" + e.getClass().toString().split(" ")[1] + "] " + e.getMessage();
		JsonResponse jr = new JsonResponse(meta, message);
		String jsonMessage = new Gson().toJson(jr);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(CONTENT_TYPE, APP_JSON_CHARSET_UTF_8);
		
		// return JSON object
		return new ResponseEntity<String>(jsonMessage, headers, HttpStatus.CREATED);
	}

}
