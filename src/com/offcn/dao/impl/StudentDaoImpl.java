package com.offcn.dao.impl;

import com.offcn.dao.StudentDao;
import com.offcn.entity.Student;
import com.offcn.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxi
 * @date 2021/8/25 16:18
 * @description
 */
public class StudentDaoImpl implements StudentDao {

    QueryRunner qr = JDBCUtil.getQueryRunner();

    @Override
    public List<Student> selectAll(){
        String sql = "select * from tb_student";
        List<Student> list = new ArrayList<>();
        try {
           list =  qr.query(sql,new BeanListHandler<>(Student.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;

    }

    @Override
    public Student getStu(int sid){
        String sql = "select * from tb_student where sid=?";
        Student s = null;
        try {
            s =  qr.query(sql,new BeanHandler<>(Student.class),sid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return s;

    }

    @Override
    public int delStu(int sid){
        String sql = "delete  from tb_student where sid=?";
        int result = 0;
        try {
            result  =  qr.update(sql,sid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;

    }

    @Override
    public int updateStu(Student s){
        int result = 0;
        String sql = "update tb_student set sname=?,sex=?,age=?,email=?,photo=? where sid=?";
        try {
            result = qr.update(sql,s.getSname(),s.getSex(),s.getAge(),s.getEmail(),s.getPhoto(),s.getSid());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    @Override
    public int insertStu(Student s){
        int result = 0;
        String sql = "insert tb_student set sname=?,sex=?,age=?,email=?,photo=?";
        try {
            result = qr.update(sql,s.getSname(),s.getSex(),s.getAge(),s.getEmail(),s.getPhoto());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }


    @Override
    public List<Student> query(String content){
        content = "%"+content+"%";
        String sql = "select * from tb_student where sid like ? or sname like ? or sex like ? or age like ? or email like ? ";
        List<Student> list = new  ArrayList<>();
        try {
            list =  qr.query(sql,new BeanListHandler<>(Student.class),content,content,content,content,content);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;

    }

    @Override
    public List<Student> getStuByPage(int index, int rows) {

        String sql = "select * from tb_student  limit ?,?";
        List<Student> list = new  ArrayList<>();
        try {
            list =  qr.query(sql,new BeanListHandler<>(Student.class),index,rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public int stuTatol(){
        int result = 0;
        String sql = "select count(*) from tb_student";
        try {
            result =(int)(long)qr.query(sql,new ScalarHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    @Override
    public  List<Student>  query(String content, int index, int rows) {
        content = "%"+content+"%";
        String sql = "select * from tb_student where sid like ? or sname like ? or sex like ? or age like ? or email like ? limit ?,?";
        List<Student> list = new  ArrayList<>();
        try {
            list =  qr.query(sql,new BeanListHandler<>(Student.class),content,content,content,content,content,index,rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

}
