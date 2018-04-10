package com.example.zuul.filter.zuul_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class EdgeErrorFilter extends ZuulFilter {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	protected static final String SEND_ERROR_FILTER_RAN = "sendErrorFilter.ran";

	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {
		return -1; //// Needs to run before SendErrorFilter which has filterOrder == 0
	}

/*	@Override
	public boolean shouldFilter() {
		return RequestContext.getCurrentContext().getThrowable() != null;
	}
*/	
	@Override
	public boolean shouldFilter() {
	    RequestContext ctx = RequestContext.getCurrentContext();
	    // only forward to errorPath if it hasn't been forwarded to already
	    return ctx.getThrowable() != null
	            && !ctx.getBoolean(SEND_ERROR_FILTER_RAN, false);
	}

	@Override
	public Object run() {
		 RequestContext ctx = RequestContext.getCurrentContext();
		 ctx.set(SEND_ERROR_FILTER_RAN); //
		    // rest of your code
		Throwable throwable = ctx.getThrowable();
		logger.error("Exception was thrown in filters: ", throwable);
		return null;
	}
}

