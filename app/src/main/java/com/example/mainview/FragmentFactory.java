package com.example.mainview;

import android.util.SparseArray;

import com.example.mainview.mainfragment.BaseFragment;
import com.example.mainview.mainfragment.CartFragment;
import com.example.mainview.mainfragment.CategoryFragment;
import com.example.mainview.mainfragment.HomeFragment;
import com.example.mainview.mainfragment.MineFragment;
import com.example.mainview.mainfragment.PromotionFragment;

public class FragmentFactory {

    private static SparseArray<BaseFragment> mFragments = new SparseArray<>();

    public static BaseFragment createFragment(int position) {
        BaseFragment fragment;
        fragment = mFragments.get(position);
        if (fragment == null) {
            switch (position) {
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new CategoryFragment();
                    break;
                case 2:
                    fragment = new PromotionFragment();
                    break;
                case 3:
                    fragment = new CartFragment();
                    break;
                case 4:
                    fragment = new MineFragment();
                    break;
                default:
                    break;
            }
            if (fragment != null) {
                mFragments.put(position, fragment);
            } else {
                LogUtil.e(FragmentFactory.class.getSimpleName(), position + " create Fragment = null");
            }
        }
        return fragment;

    }

    public static void clearFragment() {
        mFragments.clear();
    }


}
