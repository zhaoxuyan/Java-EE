package com.zhaoxuyan.entity;

public class User {
    private int uuid;
    private String uname;
    private String img_path;


    private String upwd;

    public User(int uuid, String uname, String img_path, String upwd) {
        this.uuid = uuid;
        this.uname = uname;
        this.img_path = img_path;
        this.upwd = upwd;
    }
    public User(String uname, String img_path, String upwd) {
        this.uname = uname;
        this.img_path = img_path;
        this.upwd = upwd;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}
