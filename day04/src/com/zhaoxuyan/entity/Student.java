package com.zhaoxuyan.entity;

public class Student {
    private int id;
    private String stuno;
    private String stuname;
    private String stusex;
    private int stuyear;

    public Student(int id, String stuno, String stuname, String stusex, int stuyear) {
        this.id = id;
        this.stuno = stuno;
        this.stuname = stuname;
        this.stusex = stusex;
        this.stuyear = stuyear;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex;
    }

    public void setStuyear(int stuyear) {
        this.stuyear = stuyear;
    }

    public String getStuname() {
        return stuname;
    }

    public String getStusex() {
        return stusex;
    }

    public int getStuyear() {
        return stuyear;
    }

    public int getId() {
        return id;
    }


    public String getStuno() {
        return stuno;
    }


}
