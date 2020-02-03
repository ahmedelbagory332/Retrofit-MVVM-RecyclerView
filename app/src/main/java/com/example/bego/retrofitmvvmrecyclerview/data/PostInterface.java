package com.example.bego.retrofitmvvmrecyclerview.data;

import com.example.bego.retrofitmvvmrecyclerview.pojo.PostModel;

import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {

    @GET("posts")
    public Call<List<PostModel>> getPosts();



}
