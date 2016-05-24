/**
 * Copyright (c) 2016 Samsung SDSA. All Rights Reserved.
 */
package com.samsung.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samsung.api.common.constant.CommonValue;
import com.samsung.api.common.web.JsonResponse;
import com.samsung.api.vo.Meta;

@Controller
public class BaseController 
{
	private final static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
    private MessageSourceAccessor messageSourceAccessor;
	
	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
	public @ResponseBody JsonResponse helloworld(ModelMap model) 
	{
		LOGGER.debug("[BaseController.helloworld]");
		
		Meta meta = new Meta();
    	meta.setMessage(messageSourceAccessor.getMessage(CommonValue.Message.Success.COMMON));
    	meta.setSuccess(true);
    	
    	String msg = "Hello, world!";
		
    	return new JsonResponse(meta, msg);
	}
	
	@RequestMapping(value = "/throwException", method = RequestMethod.GET)
	public @ResponseBody JsonResponse throwException() throws Exception 
	{
		LOGGER.debug("[BaseController.throwException]");
		
		throw new Exception("This is a controller level exception.");
	}
	
}