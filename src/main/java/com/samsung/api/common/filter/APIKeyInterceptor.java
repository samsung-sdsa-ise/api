package com.samsung.api.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.samsung.api.common.constant.CommonValue;

public class APIKeyInterceptor extends HandlerInterceptorAdapter 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(APIKeyInterceptor.class);

	@Value("#{system['apiKey']}")
	private String apiKey;

	@Autowired
	private MessageSourceAccessor messageSourceAccessor;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception 
	{
		LOGGER.debug("[APIKeyInterceptor.preHandle]");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String api_key = httpRequest.getParameter("api_key");

		if (null != api_key) {
			if (!(api_key.equals(apiKey))) {
				LOGGER.info("API Key in header is invalid");
				throw new Exception(messageSourceAccessor.getMessage(CommonValue.Message.Error.INVALID_API_KEY));
			}
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			LOGGER.info("API Key in header is null");
			throw new Exception(messageSourceAccessor.getMessage(CommonValue.Message.Error.NULL_API_KEY));
		}

		return true;
	}

}
