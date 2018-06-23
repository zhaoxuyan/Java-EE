package com.zhaoxuyan.entity;

public class Student {
    private int id;
    private String stuno;
    private String stuname;
    private String stusex;
    private int year;

    public Student(int id, String stuno, String stuname, String stusex, int stuyear) {
        this.id = id;
        this.stuno = stuno;
        this.stuname = stuname;
        this.stusex = stusex;
        this.year = stuyear;
    }

    public String getStuname() {
        return stuname;
    }

    public String getStusex() {
        return stusex;
    }

    public int getStuyear() {
        return year;
    }

    public int getId() {
        return id;
    }


    public String getStuno() {
        return stuno;
    }


}
