package com.example.android.instagram_clone.Profiles;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.android.instagram_clone.R;
import com.example.android.instagram_clone.Utils.SectionPagerAdapter;
import com.example.android.instagram_clone.Utils.SectionsStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by chaokuanhao on 09/09/2017.
 */

public class AccountSettingActivity extends AppCompatActivity {
    private static String TAG = AccountSettingActivity.class.getSimpleName();
    private Context mContext;
    private SectionsStatePagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mContext = AccountSettingActivity.this;
        setContentView(R.layout.activity_account_setting);
        Log.d(TAG, "onCreate started.");
        viewPager = (ViewPager) findViewById(R.id.container);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rellayout01);

        setupSettingList();
        setupFragments();
        // set up the back arrow to navigate back to the previous page
        ImageView backArrow = (ImageView) findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Navigate back to the 'ProfileAcicity'.");
                finish();
            }
        });
    }

    private void setupFragments(){
        pagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment( new EditProfileFragment(), getString(R.string.edit_profile_fragment));     // fragment 0
        pagerAdapter.addFragment( new SignOutFragment(), getString( R.string.sign_out_fragment));            // fragment 1
    }

    private void setupViewPagers( int fragmentNumber){
        mRelativeLayout.setVisibility(View.GONE);
        Log.d(TAG, "setupViewPager: navigate to fragment #:"+fragmentNumber);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(fragmentNumber);
    }


    private void setupSettingList() {
        Log.d(TAG, "setupSettingList: initializing 'Account Settings' lists");
        ListView listView = (ListView) findViewById(R.id.listViewAccountSettings);
        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile_fragment));          // fragment 0
        options.add(getString(R.string.sign_out_fragment));              // fragment 1

        ArrayAdapter adaper = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adaper);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.d(TAG, "onItemClick: navigate to fragments#: " + position);
                setupViewPagers(position);
            }
        });
    }
}
