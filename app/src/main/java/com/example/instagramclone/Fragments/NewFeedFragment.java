package com.example.instagramclone.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.instagramclone.Adapter.GroupAdapter;
import com.example.instagramclone.Objects.Stories;
import com.example.instagramclone.API.RetrofitService;
import com.example.instagramclone.Objects.NewFeed;
import com.example.instagramclone.Objects.NewFeeds;
import com.example.instagramclone.Objects.Story;
import com.example.instagramclone.R;
import com.example.instagramclone.API.RetrofitInstace;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewFeedFragment extends Fragment {
    RecyclerView recyclerView;
    GroupAdapter groupAdapter;
    ArrayList<Story> storyData;
    ArrayList<NewFeed> postData;
    ArrayList<String> groupData;
    LinearLayoutManager layoutManager;

    ImageView cammeraToolbarButton;
    Toolbar toolBar;

    public NewFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_feed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.newFeedRecycleView);
        cammeraToolbarButton = view.findViewById(R.id.cameraToolbar);

        cammeraToolbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivity(cameraIntent);
            }
        });

        
        setAdapterType();
        setAdapter();
    }

    public void initData() {
        storyData = new ArrayList<>();
        postData = new ArrayList<>();
        groupData = new ArrayList<>();

        groupData.add("stories");
        groupData.add("posts");

        getNewFeedDataRetrofit();
        getStoriesDataRetrofit();
    }

    private void setAdapter() {
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setAdapterType() {

        initData();

        groupAdapter = new GroupAdapter(getContext(), storyData, postData, groupData);
        recyclerView.setAdapter(groupAdapter);
    }

    private void getNewFeedDataRetrofit() {
        RetrofitService retrofitService = RetrofitInstace.getRetrofitInstance()
                .create(RetrofitService.class);

        Call<NewFeeds> newFeedsCall = retrofitService.getAllNewFeed();

        newFeedsCall.enqueue(new Callback<NewFeeds>() {
            @Override
            public void onResponse(Call<NewFeeds> call, retrofit2.Response<NewFeeds> response) {
                postData.addAll(response.body().getNewfeeds());
                groupAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewFeeds> call, Throwable t) {

            }
        });
    }

    private void getStoriesDataRetrofit() {
        RetrofitService retrofitService = RetrofitInstace.getRetrofitInstance()
                .create(RetrofitService.class);

        Call<Stories>  storiesCall = retrofitService.getAllStories();

        storiesCall.enqueue(new Callback<Stories>() {
            @Override
            public void onResponse(Call<Stories> call, Response<Stories> response) {
                storyData.addAll(response.body().getStories());
                groupAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Stories> call, Throwable t) {

            }
        });
    }
}
