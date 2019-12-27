package com.zkml.official_reception.server.filter;

import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * 记录日志
 */
@Component
public class RequestAccessFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        long start = System.currentTimeMillis();
        chain.doFilter(request,response);
        System.out.println(req.getRequestURL());
        System.out.println("Execute cost="+(System.currentTimeMillis()-start));
}
    @Override
    public void destroy() {

    }
}
