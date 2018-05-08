package com.example.mainview.mainfragment;

import android.support.v4.app.Fragment;

/**
 * Created by acer-pc on 2018/5/8.
 */

public class BaseFragment extends Fragment {
    @Override
    public void onDestroy(){
        super.onDestroy();
        try{
            System.gc();
            System.runFinalization();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
