package org.system.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by wangyanming on 2015/8/31.
 *
 *
 */
public class JSPfilter implements Filter
{
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println("JSP filter init!");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        System.out.println("JSP filter is processing when REQUEST passing...");

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("JSP filter is processing when RESPONSE passing...");
    }

    public void destroy()
    {
        System.out.println("JSP filter destroying");
    }
}
