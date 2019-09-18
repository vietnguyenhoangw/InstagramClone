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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.instagramclone.API.RetrofitInstace;
import com.example.instagramclone.API.RetrofitService;
import com.example.instagramclone.Adapter.GroupAdapter;
import com.example.instagramclone.Adapter.UserGridPostAdapter;
import com.example.instagramclone.Adapter.UserListPostAdapter;
import com.example.instagramclone.Objects.NewFeed;
import com.example.instagramclone.Objects.NewFeeds;
import com.example.instagramclone.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    TabLayout tabLayoutUser;

    RecyclerView userListPostRecyclerView;
    UserListPostAdapter userListPostAdapter;
    ArrayList<NewFeed> userListPostData;
    LinearLayoutManager layoutManager;

    RecyclerView userGridPostRecyclerView;
    UserGridPostAdapter userGridPostAdapter;
    ArrayList<NewFeed> userGridPostData;
    StaggeredGridLayoutManager gridLayoutManager;

    LinearLayout grid, list;

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        grid = view.findViewById(R.id.grid);
        list = view.findViewById(R.id.list);

        tabLayoutUser = view.findViewById(R.id.userTabLayout);
        userListPostRecyclerView = view.findViewById(R.id.recycleViewUserListPost);
        userGridPostRecyclerView = view.findViewById(R.id.recycleViewUserGridPost);

        tabLayoutUser.addTab(tabLayoutUser.newTab().setIcon(R.drawable.baseline_grid_on_black_48));
        tabLayoutUser.addTab(tabLayoutUser.newTab().setIcon(R.drawable.baseline_assignment_ind_black_48));

        setAdapterType();
        setAdapter();

        tabLayoutUser.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        grid.setVisibility(View.VISIBLE);
                        list.setVisibility(View.GONE);
                        break;
                    case 1:
                        list.setVisibility(View.VISIBLE);
                        grid.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void initData() {
        userListPostData = new ArrayList<>();
        userGridPostData = new ArrayList<>();

        getUserListPostDataRetrofit();
        getUserGridPostDataRetrofit();
    }

    private void setAdapter() {
        layoutManager = new LinearLayoutManager(getContext());
        userListPostRecyclerView.setLayoutManager(layoutManager);

        userGridPostRecyclerView.setHasFixedSize(true);
        gridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        userGridPostRecyclerView.setLayoutManager(gridLayoutManager);
    }

    private void setAdapterType() {
        initData();

        userListPostAdapter = new UserListPostAdapter(getContext(), userListPostData);
        userListPostRecyclerView.setAdapter(userListPostAdapter);

        userGridPostAdapter = new UserGridPostAdapter(getContext(), userGridPostData);
        userGridPostRecyclerView.setAdapter(userGridPostAdapter);
    }

    private void getUserListPostDataRetrofit() {
        RetrofitService retrofitService = RetrofitInstace.getRetrofitInstance()
                .create(RetrofitService.class);

        Call<NewFeeds> userListPost = retrofitService.getAllUserListPost();

        userListPost.enqueue(new Callback<NewFeeds>() {
            @Override
            public void onResponse(Call<NewFeeds> call, retrofit2.Response<NewFeeds> response) {
                userListPostData.addAll(response.body().getNewfeeds());
                userListPostAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewFeeds> call, Throwable t) {

            }
        });
    }

    private void getUserGridPostDataRetrofit() {
        RetrofitService retrofitService = RetrofitInstace.getRetrofitInstance()
                .create(RetrofitService.class);

        Call<NewFeeds> userListPost = retrofitService.getAllUserListPost();

        userListPost.enqueue(new Callback<NewFeeds>() {
            @Override
            public void onResponse(Call<NewFeeds> call, retrofit2.Response<NewFeeds> response) {
                userGridPostData.addAll(response.body().getNewfeeds());
                userGridPostAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewFeeds> call, Throwable t) {

            }
        });
    }
}
