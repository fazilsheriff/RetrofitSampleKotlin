package com.example.simpleget;

import com.example.myapplication.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonParseInterface {

    @GET("posts")
    Call<List<UserModel>> getPosts();

}
