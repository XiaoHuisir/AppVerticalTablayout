package com.example.a86066.appverticaltablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.a86066.appverticaltablayout.adapter.VpAndTabAdapter;
import com.example.a86066.appverticaltablayout.bean.MainBean;
import com.example.a86066.appverticaltablayout.fragment.FragmentOne;
import com.example.a86066.appverticaltablayout.presenter.TbPresenter;
import com.example.a86066.appverticaltablayout.view.TbView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import q.rorbin.verticaltablayout.VerticalTabLayout;

public class MainActivity extends AppCompatActivity implements TbView {

    @BindView(R.id.vtl)
    VerticalTabLayout vtl;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private TbPresenter presenter;
    private ArrayList<Fragment> vplist;
    private ArrayList<MainBean.DataBean.CategoryListBean> list;
    private VpAndTabAdapter vpAndTabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new TbPresenter();
        presenter.gettbpresenter();
        presenter.okattach(this);
        initView();
        initData();
    }

    private void initData() {
    }

    private void initView() {
    }

    @Override
    public void succeed(MainBean mainBean) {

        vplist = new ArrayList<>();
        list = new ArrayList<>();


        vpAndTabAdapter = new VpAndTabAdapter(getSupportFragmentManager(), vplist, list);
        viewpager.setAdapter(vpAndTabAdapter);
        vtl.setupWithViewPager(viewpager);
        List<MainBean.DataBean.CategoryListBean> categoryList = mainBean.getData()
                .getCategoryList();

        for (int i = 0; i < categoryList.size(); i++) {
        list.addAll(categoryList);
            FragmentOne fragmentOne = new FragmentOne();
           fragmentOne.setCid(categoryList.get(i).getId());
            vplist.add(fragmentOne);
        }
        vpAndTabAdapter.notifyDataSetChanged();

    }

    @Override
    public void isEnit(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onattach();
    }
}
