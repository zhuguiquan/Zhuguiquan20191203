package com.bw.zhuguiquan20191203.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bw.zhuguiquan20191203.R;
import com.bw.zhuguiquan20191203.base.BaseActivity;
import com.bw.zhuguiquan20191203.view.fragment.FaxianFragment;
import com.bw.zhuguiquan20191203.view.fragment.FenleiFragment;
import com.bw.zhuguiquan20191203.view.fragment.MyFragment;
import com.bw.zhuguiquan20191203.view.fragment.OtherFragment;
import com.bw.zhuguiquan20191203.view.fragment.ShopingCartFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private ViewPager viewPager;
    private RadioGroup radioGroup;
    List<Fragment>fragmentList=new ArrayList<>();

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.vp);
        radioGroup = findViewById(R.id.rg);
        fragmentList.add(new OtherFragment());
        fragmentList.add(new FenleiFragment());
        fragmentList.add(new FaxianFragment());
        fragmentList.add(new ShopingCartFragment());
        fragmentList.add(new MyFragment());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioGroup.check(radioGroup.getChildAt(position).getId());

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rg1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rg2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.rg3:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.rg4:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.rg5:
                        viewPager.setCurrentItem(4);
                        break;
                }
            }
        });

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
