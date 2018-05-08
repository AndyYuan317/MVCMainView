package com.example.mainview.mainfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mainview.R;


public class CartFragment extends BaseFragment {
    private LayoutInflater myInflater;
    private View rootView;
    private Context context;

    public CartFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myInflater = inflater;
        context = getContext();
        if (rootView == null) {
            rootView = myInflater.inflate(R.layout.fragment_main_cart, container, false);
        }
        return rootView;
    }
}
