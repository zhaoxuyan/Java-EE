package com.zhaoxuyan.entity;

public class Student {
    private int id;
    private String stuno;
    private String stuname;
    private String stusex;
    private int year;

    public Student(){
        super();
    }

    public Student(int id, String stuno, String stuname, String stusex, int year) {
        this.id = id;
        this.stuno = stuno;
        this.stuname = stuname;
        this.stusex = stusex;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
