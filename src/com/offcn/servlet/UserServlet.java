package com.offcn.servlet;
/**
 * @author chenxi
 * @date 2021/8/23 16:59
 * @description
 */

import com.mysql.cj.Session;
import com.offcn.dao.UserDao;
import com.offcn.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        if ("outlogin".equals(type)){
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String type = request.getParameter("type");
        System.out.println(type);
        UserDao userDao = new UserDao();
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        if ("login".equals(type)){

            User user = userDao.login(uname, pwd);
            if (user == null){
                response.sendRedirect("loginFail.html");
            }else {
                HttpSession session = request.getSession();
                session.setAttribute("uname",uname);
                String rem = request.getParameter("rem");

                if ("ok".equals(rem)){
                    Cookie cuname = new Cookie("uname", uname);
                    Cookie cpwd = new Cookie("pwd", pwd);
                    Cookie crem = new Cookie("rem", rem);
                    cuname.setMaxAge(60*60*24);
                    cpwd.setMaxAge(60*60*24);
                    crem.setMaxAge(60*60*24);
                    response.addCookie(cuname);
                    response.addCookie(cpwd);
                    response.addCookie(crem);

                }else {

                    Cookie cuname = new Cookie("uname", uname);
                    Cookie cpwd = new Cookie("pwd", pwd);
                    Cookie crem = new Cookie("rem", rem);
                    cuname.setMaxAge(0);
                    cpwd.setMaxAge(0);
                    crem.setMaxAge(0);
                    response.addCookie(cuname);
                    response.addCookie(cpwd);
                    response.addCookie(crem);
                }


                response.sendRedirect("stu?type=mainByPage&page=1");
            }
        }else if ("register".equals(type)){

            int result = userDao.register(uname, pwd);
            if (result == 0){
                response.sendRedirect("registerFail.html");
            }else {
                response.sendRedirect("registerSuccess.html");
            }
        }



    }
}
