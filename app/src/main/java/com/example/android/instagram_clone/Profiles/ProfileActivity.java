package com.example.android.instagram_clone.Profiles;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.android.instagram_clone.R;
import com.example.android.instagram_clone.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Howard on 2017/7/28.
 */

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = ProfileActivity.class.getSimpleName();
    private static final int ACTIVITY_NUM = 4;
    private Context mContext = ProfileActivity.this;

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInsatanceState){
        super.onCreate(savedInsatanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate started.");
        mProgressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        setupBottomNavigationView();
        setupToolBar();
    }

    /**
     * bottom navigation setup
     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.tv_bottom_NavViewerBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    private void setupToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);
        ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Navigating to account settings.");
                Intent intent = new Intent(mContext, AccountSettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
