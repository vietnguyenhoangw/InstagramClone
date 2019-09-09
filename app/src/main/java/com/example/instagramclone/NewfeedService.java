package com.example.instagramclone;

import com.example.instagramclone.Objects.NewFeeds;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewfeedService {
    @GET("/newfeeds")
    Call<NewFeeds> getAllNewFeed();
}
