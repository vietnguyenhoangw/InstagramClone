package com.example.instagramclone.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instagramclone.Adapter.GroupAdapter;
import com.example.instagramclone.NewfeedService;
import com.example.instagramclone.Objects.NewFeed;
import com.example.instagramclone.Objects.NewFeeds;
import com.example.instagramclone.R;
import com.example.instagramclone.RetrofitInstace;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class NewFeedFragment extends Fragment {
    RecyclerView recyclerView;
    GroupAdapter groupAdapter;
    ArrayList<String> storyData;
    ArrayList<NewFeed> postData;
    ArrayList<String> groupData;
    LinearLayoutManager layoutManager;

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
        
        setAdapterType();
        setAdapter();
    }

    public void initData() {
        storyData = new ArrayList<>();
        postData = new ArrayList<>();
        groupData = new ArrayList<>();

        storyData.add("123123123");
        storyData.add("123123123");
        storyData.add("123123123");
        storyData.add("123123123");
        storyData.add("123123123");
        storyData.add("123123123");
        storyData.add("123123123");
        storyData.add("123123123");

        getNewFeedDataRetrofit();

        postData.add(new NewFeed("i love vinaheyyyy", "312", "3 days"
                ,"daniel_nguyen"));
        postData.add(new NewFeed("nothing ...", "9871", "3 weeks"
                ,"cong_hug"));

        groupData.add("z");
        groupData.add("x");
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
        NewfeedService newfeedService = RetrofitInstace.getRetrofitInstance()
                .create(NewfeedService.class);

        Call<NewFeeds> newFeedsCall = newfeedService.getAllNewFeed();

        newFeedsCall.enqueue(new Callback<NewFeeds>() {
            @Override
            public void onResponse(Call<NewFeeds> call, retrofit2.Response<NewFeeds> response) {
//                postData.addAll(response.body().getNewfeeds());
//                groupAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewFeeds> call, Throwable t) {

            }
        });
    }
}
