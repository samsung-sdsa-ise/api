/**
 * Copyright (c) 2016 Samsung SDSA. All Rights Reserved.
 */
package com.samsung.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samsung.api.common.constant.CommonValue;
import com.samsung.api.common.web.JsonResponse;
import com.samsung.api.service.FruitService;
import com.samsung.api.vo.Fruit;
import com.samsung.api.vo.Meta;

@Controller
@RequestMapping("/f")
public class FruitController 
{
	private final static Logger LOGGER = LoggerFactory.getLogger(FruitController.class);
	
	@Autowired
    private MessageSourceAccessor messageSourceAccessor;

	@Autowired
    private FruitService fruitService;
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody JsonResponse getFruitList(Fruit fruitParam) 
	{
		LOGGER.debug("[FruitController.getFruitList]");
		
    	List<Fruit> fruitList = fruitService.getFruitList(fruitParam);

		Meta meta = new Meta();
		meta.setTotal(fruitService.getFruitListTotal(fruitParam));
    	meta.setMessage(messageSourceAccessor.getMessage(CommonValue.Message.Success.COMMON));
    	meta.setSuccess(true);
    	
    	return new JsonResponse(meta, fruitList);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public @ResponseBody JsonResponse insertFruit(Fruit fruitParam) 
	{
		LOGGER.debug("[FruitController.insertFruit]");
		
    	int insertCount = fruitService.insertFruit(fruitParam);

		Meta meta = new Meta();
		if (insertCount > 0) {
			meta.setTotal(insertCount);
	    	meta.setMessage(messageSourceAccessor.getMessage(CommonValue.Message.Success.COMMON));
	    	meta.setSuccess(true);
		} else {
	    	meta.setMessage(messageSourceAccessor.getMessage(CommonValue.Message.Error.COMMON));
	    	meta.setSuccess(false);
		}
    	
    	return new JsonResponse(meta, null);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody JsonResponse updateFruit(Fruit fruitParam) 
	{
		LOGGER.debug("[FruitController.updateFruit]");
		
    	int updateCount = fruitService.updateFruit(fruitParam);
    	
		Meta meta = new Meta();
		if (updateCount > 0) {
			meta.setTotal(updateCount);
	    	meta.setMessage(messageSourceAccessor.getMessage(CommonValue.Message.Success.COMMON));
	    	meta.setSuccess(true);
		} else {
	    	meta.setMessage(messageSourceAccessor.getMessage(CommonValue.Message.Error.COMMON));
	    	meta.setSuccess(false);
		}
    	
    	return new JsonResponse(meta, null);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody JsonResponse deleteFruit(Fruit fruitParam) 
	{
		LOGGER.debug("[FruitController.deleteFruit]");
		
    	int deleteCount = fruitService.deleteFruit(fruitParam);

		Meta meta = new Meta();
		if (deleteCount > 0) {
			meta.setTotal(deleteCount);
	    	meta.setMessage(messageSourceAccessor.getMessage(CommonValue.Message.Success.COMMON));
	    	meta.setSuccess(true);
		} else {
	    	meta.setMessage(messageSourceAccessor.getMessage(CommonValue.Message.Error.COMMON));
	    	meta.setSuccess(false);
		}
    	
    	return new JsonResponse(meta, null);
	}
	
	// testing service-level exceptions
	@RequestMapping(value = "/throwException", method = RequestMethod.GET)
	public @ResponseBody JsonResponse throwException(Fruit fruitParam) throws Exception 
	{
		LOGGER.debug("[FruitController.throwException]");
		
    	fruitService.throwException();
    	
    	return new JsonResponse(null, "This is unreachable.");
	}
}