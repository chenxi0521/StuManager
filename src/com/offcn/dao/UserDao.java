package com.offcn.dao;

import com.offcn.entity.User;
import com.offcn.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxi
 * @date 2021/8/23 16:51
 * @description
 */
public class UserDao {

    QueryRunner qr = JDBCUtil.getQueryRunner();

    public User login(String uname,String pwd){
        String sql = "select * from tb_user where uname=? and pwd=?";
        User u = null;
        try {
            u = qr.query(sql,new BeanHandler<>(User.class),uname,pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return u;
    }

    public int register(String uname,String pwd){
        String sql = "insert into tb_user set uname=?,pwd=?";
        int result = 0;
        try {
            result = qr.update(sql,uname,pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    public List<User> selectAll(){
        String sql = "select * from tb_user";
        List<User> list = new ArrayList<>();
        try {
            list = qr.query(sql,new BeanListHandler<>(User.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }


}
