package com.example.a86066.appverticaltablayout.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a86066.appverticaltablayout.R;
import com.example.a86066.appverticaltablayout.adapter.DetailsAdapter;
import com.example.a86066.appverticaltablayout.bean.DetailsBean;
import com.example.a86066.appverticaltablayout.presenter.DetailsPresenter;
import com.example.a86066.appverticaltablayout.view.DetailsView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmentOne extends Fragment implements DetailsView {
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.tv)
    TextView tv;
    private int cid;
    private DetailsPresenter presenter;
    private ArrayList<DetailsBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list;
    private DetailsAdapter adapter;
    private DetailsBean.DataBean data;


    // 张慧   H1901B
    public void setCid(int cid) {
        this.cid = cid;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, null);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }


    private void initView() {
        rv.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        presenter = new DetailsPresenter();
        presenter.okattach(this);
        presenter.getpresenter(cid);

    }

    private void initData() {
        list = new ArrayList<>();
        adapter = new DetailsAdapter(list, getActivity());
        rv.setAdapter(adapter);

    }


    @Override
    public void succeed(DetailsBean detailsBean) {

//currentCategory    subCategoryList
        data = detailsBean.getData();
        List<DetailsBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = data
                .getCurrentCategory().getSubCategoryList();

        DetailsBean.DataBean.CurrentCategoryBean currentCategory = detailsBean.getData()
                .getCurrentCategory();
        String front_desc = currentCategory.getFront_desc();
        tv.setText(front_desc);

//        wap_banner_url
        String wap_banner_url = currentCategory.getWap_banner_url();
        Glide.with(getActivity()).load(wap_banner_url).into(iv);

        list.addAll(subCategoryList);
        adapter.notifyDataSetChanged();


    }
    /*
     * TODO
     * 懒加载
     * */
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser==true){
//
//        }
//    }


//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser==true){
//
//            List<DetailsBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = data
//                    .getCurrentCategory().getSubCategoryList();
//
//            DetailsBean.DataBean.CurrentCategoryBean currentCategory = data
//                    .getCurrentCategory();
//            String front_desc = currentCategory.getFront_desc();
//            tv.setText(front_desc);
//
////        wap_banner_url
//            String wap_banner_url = currentCategory.getWap_banner_url();
//            Glide.with(getActivity()).load(wap_banner_url).into(iv);
//
//            list.addAll(subCategoryList);
//            adapter.notifyDataSetChanged();
//
//        }
//    }

    @Override
    public void isEnit(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.onattach();
    }
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        presenter.onattach();
//    }
}
