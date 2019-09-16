package com.example.instagramclone.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instagramclone.API.RetrofitInstace;
import com.example.instagramclone.API.RetrofitService;
import com.example.instagramclone.Adapter.CategoriesAdapter;
import com.example.instagramclone.Adapter.GroupAdapter;
import com.example.instagramclone.Adapter.RandomPostAdapter;
import com.example.instagramclone.Objects.Categories;
import com.example.instagramclone.Objects.Category;
import com.example.instagramclone.Objects.NewFeed;
import com.example.instagramclone.Objects.NewFeeds;
import com.example.instagramclone.Objects.Stories;
import com.example.instagramclone.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    RecyclerView recyclerView;
    CategoriesAdapter categoriesAdapter;
    ArrayList<Category> categoryData;
    LinearLayoutManager layoutManager;

    RecyclerView randomPostRCV;
    RandomPostAdapter randomPostAdapter;
    ArrayList<NewFeed> newfeedData;
    StaggeredGridLayoutManager randomPostLayoutManager;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.categoriesRecycleView);
        randomPostRCV = view.findViewById(R.id.randomPostRecycleView);

        setAdapterType();
        setAdapter();
    }

    private void setAdapter() {
        initData();

        categoriesAdapter = new CategoriesAdapter(getContext(), categoryData);
        recyclerView.setAdapter(categoriesAdapter);

        randomPostAdapter = new RandomPostAdapter(getContext(), newfeedData);
        randomPostRCV.setAdapter(randomPostAdapter);
    }

    private void initData() {
        categoryData = new ArrayList<>();
        newfeedData = new ArrayList<>();

        getCategoriesRetrofit();
        getRandomPostRetrofit();
    }

    private void setAdapterType() {
        layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        randomPostLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        randomPostRCV.setLayoutManager(randomPostLayoutManager);
    }

    private void getCategoriesRetrofit() {
        RetrofitService retrofitService = RetrofitInstace.getRetrofitInstance()
                .create(RetrofitService.class);

        Call<Categories> categoriesCall = retrofitService.getAllCategories();

        categoriesCall.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                categoryData.addAll(response.body().getCategories());
                categoriesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {

            }
        });
    }

    private void getRandomPostRetrofit() {
        RetrofitService retrofitService = RetrofitInstace.getRetrofitInstance()
                .create(RetrofitService.class);

        Call<NewFeeds> newFeedsCall = retrofitService.getAllNewFeed();

        newFeedsCall.enqueue(new Callback<NewFeeds>() {
            @Override
            public void onResponse(Call<NewFeeds> call, Response<NewFeeds> response) {
                newfeedData.addAll(response.body().getNewfeeds());
                randomPostAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewFeeds> call, Throwable t) {

            }
        });
    }
}
