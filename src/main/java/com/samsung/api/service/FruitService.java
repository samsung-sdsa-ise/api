/**
 * Copyright (c) 2016 Samsung SDSA. All Rights Reserved.
 */
package com.samsung.api.service;

import java.util.List;

import com.samsung.api.vo.Fruit;

public interface FruitService 
{
	int getFruitListTotal(Fruit fruitParam);
	List<Fruit> getFruitList(Fruit fruitParam);
	int insertFruit(Fruit fruitParam);
	int updateFruit(Fruit fruitParam);
	int deleteFruit(Fruit fruitParam);
	
	void throwException() throws Exception;
}
