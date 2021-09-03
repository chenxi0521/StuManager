package com.offcn.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxi
 * @date 2021/8/30 17:08
 * @description
 */
@WebListener
public class LoginListener implements ServletContextListener, HttpSessionAttributeListener, HttpSessionListener {
    ServletContext sc = null;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<String> list = new ArrayList<>();
        sc = sce.getServletContext();
        sc.setAttribute("OnlineUsers",list);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        List<String> list = (List<String>)sc.getAttribute("OnlineUsers");
        String uname = se.getName();
        if ("uname".equals(uname)){
            list.add((String) se.getValue());
        }
        sc.setAttribute("OnlineUsers",list);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        List<String> list = (List<String>)sc.getAttribute("OnlineUsers");
        list.remove(se.getSession().getAttribute("uname"));

        sc.setAttribute("OnlineUsers",list);
    }
}
