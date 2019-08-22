package com.example.a86066.appverticaltablayout.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.a86066.appverticaltablayout.bean.MainBean;

import java.util.ArrayList;

public class VpAndTabAdapter  extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> vplist;
    private ArrayList<MainBean.DataBean.CategoryListBean> list;

    public VpAndTabAdapter(FragmentManager fm, ArrayList<Fragment> vplist, ArrayList<MainBean
            .DataBean.CategoryListBean> list) {
        super(fm);
        this.vplist = vplist;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return vplist.get(position);
    }

    @Override
    public int getCount() {
        return vplist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return  list.get(position).getName();
    }
}
