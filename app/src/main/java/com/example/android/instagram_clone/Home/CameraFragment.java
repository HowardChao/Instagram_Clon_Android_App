package com.example.android.instagram_clone.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.instagram_clone.R;

/**
 * Created by Howard on 2017/7/28.
 */

public class CameraFragment extends Fragment{
    private static final String TAG = CameraFragment.class.getSimpleName();

    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_camera, container, false);
        return view;
    }
}
