package org.system.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by david on 13-11-14.
 * xss filter
 */
public class CrossScriptingFilter implements Filter
{

    /* (non-Javadoc)
    	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
    	 */

    	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException
        {
            System.out.println("XSS filter is working...");
            CrossScriptingRequestWrapper xssRequest = new CrossScriptingRequestWrapper((HttpServletRequest) request);
    		filterChain.doFilter(xssRequest, response);
    	}


    	public void destroy() {
    		// TODO Auto-generated method stub
    	}



    	public void init(FilterConfig arg0) throws ServletException
        {
    		// TODO Auto-generated method stub
    	}
}
