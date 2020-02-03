package com.example.bego.retrofitmvvmrecyclerview.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.bego.retrofitmvvmrecyclerview.data.PostsClient;
import com.example.bego.retrofitmvvmrecyclerview.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostViewModel extends ViewModel {

    MutableLiveData<List<PostModel>> postsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> posts = new MutableLiveData<>();
    private static final String TAG = "PostViewModel";
    public void getPosts() {
        PostsClient.getINSTANCE().getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postsMutableLiveData.setValue(response.body());
                Log.d(TAG, "aly onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                posts.setValue("errr");
                Log.d(TAG, "\naly onFailure: " + t.getMessage());

            }
        });
    }

}
