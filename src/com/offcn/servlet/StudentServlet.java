package com.offcn.servlet;

import com.offcn.entity.Student;
import com.offcn.service.StudentService;
import com.offcn.service.impl.StudentServiceIpml;
import com.offcn.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author chenxi
 * @date 2021/8/25 16:28
 * @description
 */
@MultipartConfig
@WebServlet("/stu")
public class StudentServlet extends BaseServlet {


    StudentService sd = new StudentServiceIpml();
    int rows = 5;

    protected void getStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
        Student stu = sd.getStu(sid);
        req.setAttribute("stu",stu);
        req.getRequestDispatcher("form.jsp").forward(req,resp);
    }

    protected void mainPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> stuAll = sd.getStuAll();
        req.setAttribute("stuAll",stuAll);
        HttpSession session = req.getSession();
        int tatol = sd.stuTatol();
        session.setAttribute("pageTatol",tatol);
        req.getRequestDispatcher("stuManager.jsp").forward(req,resp);
    }

    protected void mainByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        int tatol = sd.stuTatol();
        PageUtil pu = new PageUtil(page,rows,tatol);
        List<Student> stuAll = sd.getStuByPage(pu.getIndex(),pu.getRows());
        HttpSession session = req.getSession();

        //List<String> onlineUsers = (List<String>)session.getAttribute("OnlineUsers");
        //req.setAttribute("OnlineUsers",onlineUsers.size());
        req.setAttribute("stuAll",stuAll);
        req.setAttribute("pu",pu);
        req.getRequestDispatcher("stuManager.jsp").forward(req,resp);
    }


    protected void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
        int result = sd.delStu(sid);
        resp.sendRedirect("stu?type=mainByPage");
    }

    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getParameter("select");
        HttpSession session = req.getSession();
        session.setAttribute("select",content);
        String select = (String)session.getAttribute("select");
        System.out.println(select + 1);
        String page = req.getParameter("page");

        if (content.equals("")){
            session.removeAttribute("select");
            resp.sendRedirect("stu?type=mainByPage");
        }else {

            System.out.println(select);
            List<Student> like = sd.query(select);
            PageUtil pu = new PageUtil(page,rows,like.size());
            List<Student> stuAll = sd.query(select,pu.getIndex(),pu.getRows());
            req.setAttribute("pu",pu);
            req.setAttribute("stuAll",stuAll);
            req.getRequestDispatcher("qureyManager.jsp").forward(req,resp);
        }
    }

    protected void batchDel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sids = req.getParameter("sids");
        String[] split = sids.split(",");
        for (String s : split) {
            int i = sd.delStu(Integer.parseInt(s));
        }

        resp.sendRedirect("stu?type=mainByPage");
    }

    protected void alter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sid = req.getParameter("sid");
        String sname = req.getParameter("sname");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String email = req.getParameter("email");

        String oldPhoto = req.getParameter("oldPhoto");
        String path ="D:/develop/data/stuphoto";
        Part p = req.getPart("photo");
        String photo =  p.getSubmittedFileName();
        System.out.println(photo);
        if("".equals(photo)||photo == null){
            photo = oldPhoto;
        }else {
            File oldf =new File(path+"/"+oldPhoto);
            oldf.delete();
            photo = UUID.randomUUID() + p.getSubmittedFileName();
            p.write(path+"/"+photo);
        }

        Student s = new Student(Integer.parseInt(sid), sname, sex, Integer.parseInt(age), email, photo);

        boolean res = sd.updateStu(s);
        System.out.println(s);

        if (res){
            resp.sendRedirect("stu?type=mainByPage");
        }else {
            resp.sendRedirect("stu?type=getStu&sid="+sid);
        }

    }

    protected void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String sname = req.getParameter("sname");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String email = req.getParameter("email");

        Part p = req.getPart("photo");

        String photo = UUID.randomUUID() + p.getSubmittedFileName();
        String path ="D:/develop/data/stuphoto";
        File f = new File(path);
        if (!f.exists()){
            f.mkdirs();
        }
        p.write(path+"/"+photo);
        boolean res = sd.insertStu(new Student(sname, sex, Integer.parseInt(age), email,photo));
        if (res){
            resp.sendRedirect("stu?type=mainByPage&page=1");
        }else {
            resp.sendRedirect("insert.jsp");
        }


    }



}
