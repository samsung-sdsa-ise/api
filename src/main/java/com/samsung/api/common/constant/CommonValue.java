/**
 * Copyright (c) 2016 Samsung SDSA. All Rights Reserved.
 */
package com.samsung.api.common.constant;

public interface CommonValue 
{
	public interface Constant 
	{
		// Constants 
		public static final String YN_Y = "Y";
		public static final String YN_N = "N";
	
		// Path Variables
		public static final String REMOTE_ID = "remote_id";
		public static final String GUID = "guid";
		public static final String API_KEY = "api_key";
	}
	
	// see message.properties
	public interface Message 
	{
		// Success Messages 
		public interface Success {
			public static final String COMMON = "message.success.common";
		}
	
		// Error Messages 
		public interface Error {
			public static final String COMMON = "message.error.common";
			public static final String NULL_API_KEY = "message.error.null.api.key";
			public static final String INVALID_API_KEY = "message.error.invalid.api.key";
		}
	}
}
