package com.trans.webapp.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限过滤链
 *
 * @author mashaobo
 */
@WebFilter(urlPatterns = "/*", filterName = "LimitsOfAuthorityFilter")
public class LimitsOfAuthorityFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(LimitsOfAuthorityFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }


    private void writeError(HttpServletResponse response, String s) throws IOException {
        response.setStatus(403);
        response.setContentType("text/plain; charset=utf-8");
        response.getWriter().println(s);
    }

    @Override
    public void destroy() {

    }
}
