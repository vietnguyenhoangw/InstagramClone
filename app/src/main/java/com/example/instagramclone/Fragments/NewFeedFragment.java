package com.example.instagramclone.Fragments;

import android.content.Context;
import android.net.Uri;
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
import com.example.instagramclone.R;

import java.util.ArrayList;

public class NewFeedFragment extends Fragment {
    RecyclerView recyclerView;
    GroupAdapter groupAdapter;
    ArrayList<String> storyData;
    ArrayList<String> postData;
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

        postData.add("a");
        postData.add("b");
        postData.add("c");
        postData.add("a");
        postData.add("b");
        postData.add("c");
        postData.add("a");
        postData.add("b");
        postData.add("c");

        groupData.add("z");
        groupData.add("x");
    }

    private void setAdapter() {
        recyclerView = getActivity().findViewById(R.id.newFeedRecycleView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setAdapterType() {
        initData();

        groupAdapter = new GroupAdapter(getContext(), storyData, postData, groupData);
        recyclerView.setAdapter(groupAdapter);
    }
}
