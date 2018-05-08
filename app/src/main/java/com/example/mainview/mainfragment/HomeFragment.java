package com.example.mainview.mainfragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mainview.R;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by acer-pc on 2018/5/8.
 */

public class HomeFragment extends BaseFragment {
    private Context context = null;
    private Map<Integer, Bitmap> mImageCache = new HashMap<>();
    private LayoutInflater myInflater;
    private View rootView;
    private RecyclerView homeRecycler;

    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getContext();
        myInflater = inflater;
        if (rootView == null) {
            rootView = myInflater.inflate(R.layout.fragment_main_home, container, false);
        }
        initView();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

    }
    public void initView() {
        homeRecycler = rootView.findViewById(R.id.home);
        LinearLayoutManager homeManager = new LinearLayoutManager(context);
        homeManager.setOrientation(LinearLayoutManager.VERTICAL);
        homeRecycler.setLayoutManager(homeManager);
    }

}

