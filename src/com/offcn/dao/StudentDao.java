package com.offcn.dao;

import com.offcn.entity.Student;

import java.util.List;

/**
 * @author chenxi
 * @date 2021/8/27 9:42
 * @description
 */
public interface StudentDao {
    public List<Student> selectAll();
    public Student getStu(int sid);
    public int delStu(int sid);
    public int updateStu(Student s);
    public int insertStu(Student s);
    public List<Student> query(String content);
    public List<Student> getStuByPage(int index,int rows);
    public int stuTatol();
    List<Student> query(String content,int index, int rows);
}
