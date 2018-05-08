package com.example.mainview.mainfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mainview.R;
public class PromotionFragment extends BaseFragment {
    private LayoutInflater myInflater;
    private View rootView;
    private RecyclerView recycler;
    private Context context;


    public PromotionFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myInflater = inflater;
        context = getContext();
        if (rootView == null) {
            rootView = myInflater.inflate(R.layout.fragment_main_surprise, container, false);
        }
        return rootView;
    }


}
