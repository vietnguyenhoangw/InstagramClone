package com.example.instagramclone.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instagramclone.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    TabLayout tabLayoutUser;

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

        tabLayoutUser = view.findViewById(R.id.userTabLayout);

        tabLayoutUser.addTab(tabLayoutUser.newTab().setIcon(R.drawable.baseline_grid_on_black_48));
        tabLayoutUser.addTab(tabLayoutUser.newTab().setIcon(R.drawable.baseline_assignment_ind_black_48));
    }
}
