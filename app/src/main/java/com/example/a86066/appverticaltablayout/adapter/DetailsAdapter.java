package com.example.a86066.appverticaltablayout.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a86066.appverticaltablayout.R;
import com.example.a86066.appverticaltablayout.bean.DetailsBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {
    private ArrayList<DetailsBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list;
    private Context context;

    public DetailsAdapter(ArrayList<DetailsBean.DataBean.CurrentCategoryBean.SubCategoryListBean>
                                  list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_details,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getWap_banner_url()).into(holder.ivTv);
        holder.tv.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_tv)
        ImageView ivTv;
        @BindView(R.id.tv)
        TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }


}
