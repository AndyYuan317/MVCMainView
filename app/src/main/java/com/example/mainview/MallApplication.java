package com.example.mainview;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by acer-pc on 2018/5/7.
 */

public class MallApplication extends AppCompatActivity {
    public static boolean hasPromotion = true;
    public static Activity activity;
    private static MallApplication application;
    private static Handler handler;
    private static int mainThreadId;
    private Context context;
    private static ProgressDialog progressDialog;
    private static boolean shows;
    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        application = this;
        context = getApplicationContext();
        handler = new Handler();
        mainThreadId = android.os.Process.myPid();

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();

    }
}

