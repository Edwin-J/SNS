package com.example.minjae.vacation.Server;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Minjae on 2017-02-17.
 */

public interface Okhttp {
    public static final String URL = "http://nh.applepi.kr";

    @FormUrlEncoded
    @POST("/login")
    Call<User> login(@Field("user_id") String user_id, @Field("user_password") String user_pw);

    @FormUrlEncoded
    @POST("/register")
    Call<User> register(@Field("user_id") String user_id, @Field("user_password") String user_pw, @Field("user_name") String user_name);

    @FormUrlEncoded
    @POST("/loadlist")
    Call<List<User>> loadlist();

    @FormUrlEncoded
    @POST("/savechat")
    Call<Chat> save(@Field("roomnumber") String room, @Field("who") String who, @Field("msg") String msg);

    @FormUrlEncoded
    @POST("/loadlist")
    Call<List<Chat>> loadchat();
}
