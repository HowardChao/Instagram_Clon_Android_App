package com.example.android.instagram_clone.Home;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.instagram_clone.R;
import com.example.android.instagram_clone.Utils.BottomNavigationViewHelper;
import com.example.android.instagram_clone.Utils.SectionPagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();
    private static final int ACTIVITY_NUM = 0;
    private Context mContext = HomeActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate starting.");
        setupBottomNavigationView();
        setupViewPager();
    }

    /**
     * Resposible for adding three tabs : camera, Home, Message
     */
    private void setupViewPager(){
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment( new CameraFragment());     // index 0
        adapter.addFragment( new HomeFragment());       //index 1
        adapter.addFragment( new MessageFragment());       //index 2
        ViewPager viewPager = (ViewPager)findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_main);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);
    }

    /**
     * Bottom navigationView set up
     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.tv_bottom_NavViewerBar);
        BottomNavigationViewHelper bottomNavigationViewHelper = null;
        bottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        bottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

}
