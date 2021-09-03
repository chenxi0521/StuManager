package com.offcn.service.impl;

import com.offcn.dao.StudentDao;
import com.offcn.dao.impl.StudentDaoImpl;
import com.offcn.entity.Student;
import com.offcn.service.StudentService;

import java.util.List;

/**
 * @author chenxi
 * @date 2021/8/27 9:48
 * @description
 */
public class StudentServiceIpml implements StudentService {

    StudentDao sd = new StudentDaoImpl();

    @Override
    public List<Student> getStuAll() {

        List<Student> stuAll = sd.selectAll();
        return stuAll;
    }

    @Override
    public Student getStu(int sid) {
        Student stu = sd.getStu(sid);
        return stu;

    }

    @Override
    public int delStu(int sid) {
        int i = sd.delStu(sid);
        return i;
    }

    @Override
    public boolean updateStu(Student s) {
        int i = sd.updateStu(s);
        return i!=0?true:false;
    }

    @Override
    public boolean insertStu(Student s) {
        int i = sd.insertStu(s);
        return i!=0?true:false;
    }

    @Override
    public List<Student> query(String content) {
        List<Student> query = sd.query(content);
        return query;
    }

    @Override
    public List<Student> getStuByPage(int index, int rows) {
        List<Student> stuByPage = sd.getStuByPage(index, rows);
        return stuByPage;
    }

    @Override
    public int stuTatol() {
        int tatol = sd.stuTatol();
        return tatol;
    }

    @Override
    public List<Student> query(String content, int index, int rows) {
        List<Student> query = sd.query(content, index, rows);
        return query;
    }
}
