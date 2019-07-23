package com.vasu.netflixzullapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.protocol.RequestContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZullLoggingFilter extends ZuulFilter {
	
	private static final Logger logger = LoggerFactory.getLogger(ZullLoggingFilter.class);


	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("vvv::  requst="+request + " ,uri= "+request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";               //"pre","post","error"
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
