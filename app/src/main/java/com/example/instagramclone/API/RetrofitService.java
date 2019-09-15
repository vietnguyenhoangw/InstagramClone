package com.example.instagramclone.API;

import com.example.instagramclone.Objects.Categories;
import com.example.instagramclone.Objects.NewFeeds;
import com.example.instagramclone.Objects.Stories;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("/newfeeds")
    Call<NewFeeds> getAllNewFeed();

    @GET("/stories")
    Call<Stories> getAllStories();

    @GET("/categories")
    Call<Categories> getAllCategories();
}
