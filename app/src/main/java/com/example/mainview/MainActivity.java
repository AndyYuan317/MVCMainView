package com.example.mainview;


import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentManager;

import android.view.KeyEvent;


import com.example.mainview.mainfragment.BaseFragment;

public class MainActivity extends BaseFragmentActivity {

private ViewPager viewPager;
    private FragmentPagerAdapter mFragmentAdapter;
    private int pageNumber = 4;//默认底部四个页签
    private int pageOffScreenLimit = 4;//viewpager缓存数量
    private TabGroup tabs;//底部控件


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        MallApplication.activity = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FragmentFactory.clearFragment();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(false);//ps: move activity to back but not to destroyed.
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected boolean isMainActivity() {
        return true;
    }

    public void initView() {
        viewPager = findViewById(R.id.content);
        tabs = findViewById(R.id.tabs);
        tabs.updateSelected(0);
        RuntimeConfig.tabGroup = tabs;
    }

    private void initEvent() {
        viewPager.setAdapter(mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(pageOffScreenLimit);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                BaseFragment fragment = (BaseFragment) mFragmentAdapter.getItem(position);
                tabs.updateSelected(position);//monkey测试发现index错乱
//                fragment.setStatusBarColor(MainActivity.this);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabs.setOnTabChangeListener(new TabGroup.TabSelectListener() {
            @Override
            public boolean onTabSelected(int index) {
                viewPager.setCurrentItem(index, false);
                return true;
            }
        });
    }


    private class FragmentAdapter extends FragmentPagerAdapter {

        FragmentAdapter(FragmentManager fm) {

            super(fm);
        }

        @Override
        public Fragment getItem(int position) { //be called when no exit_y cache pager
            return FragmentFactory.createFragment(MallApplication.getPostion(position));
        }

        @Override
        public int getCount() {
            return pageNumber + (MallApplication.hasPromotion ? 1 : 0);
        }

        public BaseFragment getNowFragment() {
            return null;
        }
    }

}