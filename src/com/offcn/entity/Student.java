package com.offcn.entity;

/**
 * @author chenxi
 * @date 2021/8/25 16:15
 * @description
 */
public class Student {
    private int sid;
    private String sname;
    private String sex;
    private int age;
    private String email;
    private String photo;

    public Student(int sid, String sname, String sex, int age, String email) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.age = age;
        this.email = email;
    }

    public Student(int sid, String sname, String sex, int age, String email, String photo) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.photo = photo;
    }

    public Student(String sname, String sex, int age, String email, String photo) {
        this.sname = sname;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Student() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
