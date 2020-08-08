package com.example.simpleget;

import com.example.myapplication.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonParseInterface {

    @GET("posts")
    Call<List<UserModel>> getPosts();
    @GET("posts/{id}")
    Call<UserModel> getPosts(@Path("id") int id);


}
