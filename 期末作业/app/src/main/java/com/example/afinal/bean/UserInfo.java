package com.example.afinal.bean;

public class UserInfo {
    public long rowid;
    public int sn;
    public String name;
    public int age;
    public boolean gender;
    public String update_time;
    public String phone;
    public String pwd;

    public UserInfo() {
        rowid = 0L;
        sn = 0;
        name = "";
        age = 0;
        gender = false;
        update_time = "";
        phone = "";
        pwd = "";
    }
}
