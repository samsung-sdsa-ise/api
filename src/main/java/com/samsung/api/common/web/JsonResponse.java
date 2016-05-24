/**
 * Copyright (c) 2016 Samsung SDSA. All Rights Reserved.
 */
package com.samsung.api.common.web;

import java.io.Serializable;

public class JsonResponse implements Serializable 
{
	private static final long serialVersionUID = -5335355802591932596L;

	private Object meta;
	private Object data;
	
	/**
	 * Default Constructor overloading
	 */
	public JsonResponse() {}
	
	/**
	 * Data Constructor overloading
	 * @param result
	 */
	public JsonResponse(Object meta, Object data) {
		this.meta = meta;
		this.data = data;
	}

	public JsonResponse(Object meta) {
		this.meta = meta;
	}

	public Object getMeta() {
		return meta;
	}

	public void setMeta(Object meta) {
		this.meta = meta;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonResponse [meta=" + meta + ", data=" + data + "]";
	}
		
}
