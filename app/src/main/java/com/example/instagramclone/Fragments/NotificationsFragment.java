package com.example.instagramclone.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.instagramclone.API.RetrofitInstace;
import com.example.instagramclone.API.RetrofitService;
import com.example.instagramclone.Adapter.NotificationAdapter;
import com.example.instagramclone.Objects.NewFeed;
import com.example.instagramclone.Objects.NewFeeds;
import com.example.instagramclone.Objects.Notification;
import com.example.instagramclone.Objects.Notifications;
import com.example.instagramclone.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationsFragment extends Fragment {

    ListView listView;
    ArrayList<Notification> arrayList;
    NotificationAdapter notificationAdapter;


    public NotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.notification_listView);

        arrayList = new ArrayList<>();

        notificationAdapter = new NotificationAdapter(getContext(), R.layout.notification_item,
                arrayList);

        listView.setAdapter(notificationAdapter);

        getNotificationDataRetrofit();
    }

    public void getNotificationDataRetrofit() {
        RetrofitService retrofitService = RetrofitInstace.getRetrofitInstance()
                .create(RetrofitService.class);

        Call<Notifications> notificationsCall = retrofitService.getAllNotification();

        notificationsCall.enqueue(new Callback<Notifications>() {
            @Override
            public void onResponse(Call<Notifications> call, Response<Notifications> response) {
                arrayList.addAll(response.body().getNotifications());
                notificationAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Notifications> call, Throwable t) {

            }
        });
    }
}
