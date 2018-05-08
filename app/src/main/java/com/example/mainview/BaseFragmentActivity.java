package com.example.mainview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

public class BaseFragmentActivity extends FragmentActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_x_enter, R.anim.close_x_exit);
        try {
            System.gc();
            System.runFinalization();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected boolean isMainActivity() {
        return false;
    }
}
