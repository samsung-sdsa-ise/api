/**
 * Copyright (c) 2016 Samsung SDSA. All Rights Reserved.
 */
package com.samsung.api.vo;

import java.io.Serializable;

public class User implements Serializable 
{
	private static final long serialVersionUID = -7290111095544086823L;
	
	private String name;
	private Integer age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
