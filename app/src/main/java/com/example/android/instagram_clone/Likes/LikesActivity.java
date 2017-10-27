package com.example.android.instagram_clone.Likes;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.instagram_clone.R;
import com.example.android.instagram_clone.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by Howard on 2017/7/28.
 */

public class LikesActivity extends AppCompatActivity {
    private static final String TAG = LikesActivity.class.getSimpleName();
    private static final int ACTIVITY_NUM = 3;
    private Context mContext = LikesActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInsatanceState){
        super.onCreate(savedInsatanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate started.");
        setupBottomNavigationView();
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
}
