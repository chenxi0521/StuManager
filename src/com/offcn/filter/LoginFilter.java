package com.offcn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author chenxi
 * @date 2021/8/30 16:47
 * @description
 */
@WebFilter(urlPatterns = {"/form.jsp","/insert.jsp","/qureyManager.jsp","/stuManager.jsp","/stu/*"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        HttpSession session = request.getSession();
        Object uname = session.getAttribute("uname");
        if (uname == null){
            response.sendRedirect("loginFail.html");
        }else {
            filterChain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}
