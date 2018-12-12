package com.bw.ymy.day13.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.ymy.day13.R;
import com.bw.ymy.day13.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

//流式布局
public class StatgeAdapter extends  RecyclerView.Adapter<StatgeAdapter.ViewHolder>{
    private List<UserBean.DataBean> mdatas;
    private Context mcontext;



    public StatgeAdapter(Context context) {
        mcontext=context;
        mdatas=new ArrayList<>();
    }

    public  void  addItem(List<UserBean.DataBean> datas)
    {
        mdatas.addAll(datas);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public StatgeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stage_item,viewGroup,false);
        return new StatgeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatgeAdapter.ViewHolder viewHolder, int i) {

        UserBean.DataBean user=mdatas.get(i);
        viewHolder.title.setText(user.getName());
        Glide.with(mcontext).load(user.getIcon()).into(viewHolder.imageview);

    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView title;
        public final ImageView imageview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_recycle_staggered);
            imageview = itemView.findViewById(R.id.iv_recycle_staggered);
        }
    }
}