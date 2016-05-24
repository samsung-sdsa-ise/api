/**
 * Copyright (c) 2016 Samsung SDSA. All Rights Reserved.
 */
package com.samsung.api.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.api.persistence.FruitMapper;
import com.samsung.api.service.FruitService;
import com.samsung.api.vo.Fruit;

@Service
public class FruitServiceImpl implements FruitService 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(FruitServiceImpl.class);
	
    @Autowired
    private FruitMapper fruitMapper;

	@Override
	public int getFruitListTotal(Fruit fruitParam) {
		return fruitMapper.selectFruitListTotal(fruitParam);
	}
	
	@Override
	public List<Fruit> getFruitList(Fruit fruitParam) {
		return fruitMapper.selectFruitList(fruitParam);
	}

	@Override
	public int insertFruit(Fruit fruitParam) {
		return fruitMapper.insertFruit(fruitParam);
	}

	@Override
	public int updateFruit(Fruit fruitParam) {
		return fruitMapper.updateFruit(fruitParam);
	}

	@Override
	public int deleteFruit(Fruit fruitParam) {
		return fruitMapper.deleteFruit(fruitParam);
	}
	
	@Override
	public void throwException() throws Exception {
		throw new Exception("This is a service layer exception. Testing rollback...");
	}
}
