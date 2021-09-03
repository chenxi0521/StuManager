package com.offcn.service;

import com.offcn.entity.Student;

import java.util.List;

/**
 * @author chenxi
 * @date 2021/8/27 9:46
 * @description
 */
public interface StudentService {

    public List<Student> getStuAll();
    public Student getStu(int sid);
    public int delStu(int sid);
    public boolean updateStu(Student s);
    public boolean insertStu(Student student);
    public List<Student> query(String content);
    public List<Student> getStuByPage(int index,int rows);
    public int stuTatol();
    List<Student> query(String content,int index, int rows);
}
