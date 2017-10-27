package com.example.android.instagram_clone.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Howard on 2017/7/28.
 */

/**
 * Class for storing fragments for tabs
 */
public class SectionPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = SectionPagerAdapter.class.getSimpleName();
    private final List<Fragment> mFragmntList = new ArrayList<Fragment>();
    public SectionPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmntList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmntList.size();
    }

    public void addFragment(Fragment fragment){
        mFragmntList.add(fragment);
    }
}
