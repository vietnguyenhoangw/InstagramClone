package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayoutNavbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationBar();
    }

    public void bottomNavigationBar() {
        tabLayoutNavbar = findViewById(R.id.tabLayout);
        tabLayoutNavbar.addTab(tabLayoutNavbar.newTab().setIcon(R.drawable.home));
        tabLayoutNavbar.addTab(tabLayoutNavbar.newTab().setIcon(R.drawable.search));
        tabLayoutNavbar.addTab(tabLayoutNavbar.newTab().setIcon(R.drawable.addposts));
        tabLayoutNavbar.addTab(tabLayoutNavbar.newTab().setIcon(R.drawable.like));
        tabLayoutNavbar.addTab(tabLayoutNavbar.newTab().setIcon(R.drawable.user));
    }
}

