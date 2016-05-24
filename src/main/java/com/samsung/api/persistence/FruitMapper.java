/**
 * Copyright (c) 2016 Samsung SDSA. All Rights Reserved.
 */
package com.samsung.api.persistence;

import java.util.List;

import com.samsung.api.vo.Fruit;

public interface FruitMapper 
{
	int selectFruitListTotal(Fruit fruitParam);
	List<Fruit> selectFruitList(Fruit fruitParam);
	int insertFruit(Fruit fruitParam);
	int updateFruit(Fruit fruitParam);
	int deleteFruit(Fruit fruitParam);
}
