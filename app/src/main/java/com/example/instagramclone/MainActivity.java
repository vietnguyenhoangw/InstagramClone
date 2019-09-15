package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.example.instagramclone.Fragments.AddPostFragment;
import com.example.instagramclone.Fragments.NewFeedFragment;
import com.example.instagramclone.Fragments.NotificationsFragment;
import com.example.instagramclone.Fragments.SearchFragment;
import com.example.instagramclone.Fragments.UserFragment;
import com.google.android.material.tabs.TabLayout;
public class MainActivity extends AppCompatActivity {

    TabLayout tabLayoutNavbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationBar();

        /* always default NewFeed Tab */
        selectIndexNavBarTabs(0);

        tabLayoutNavbar.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                selectIndexNavBarTabs(tabLayoutNavbar.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    /* bottom navigation bar */
    public void bottomNavigationBar() {
        tabLayoutNavbar = findViewById(R.id.tabLayout);
        tabLayoutNavbar.addTab(tabLayoutNavbar.newTab().setIcon(R.drawable.home));
        tabLayoutNavbar.addTab(tabLayoutNavbar.newTab().setIcon(R.drawable.search));
        tabLayoutNavbar.addTab(tabLayoutNavbar.newTab().setIcon(R.drawable.addposts));
        tabLayoutNavbar.addTab(tabLayoutNavbar.newTab().setIcon(R.drawable.like));
        tabLayoutNavbar.addTab(tabLayoutNavbar.newTab().setIcon(R.drawable.user));
    }

    /* bottom nav bar select tabs */
    public void selectIndexNavBarTabs(int tabPosition) {
        Fragment fragment = null;

        switch (tabPosition) {
            case 0:
                fragment = new NewFeedFragment();
                break;
            case 1:
                fragment = new SearchFragment();
                break;
            case 2:
                fragment = new AddPostFragment();
                break;
            case 3:
                fragment = new NotificationsFragment();
                break;
            case 4:
                fragment = new UserFragment();
                break;
        }

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.commit();
    }
}

