package com.example.minjae.vacation.Server;

/**
 * Created by Minjae on 2017-02-27.
 */

public class User {
    public String id;
    public String user_id;
    public String user_pw;
    public String user_name;

    public User(String id, String user_id, String user_pw, String user_name){
        this.id = id;
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.user_name = user_name;
    }
}
