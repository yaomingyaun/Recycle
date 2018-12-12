package com.bw.ymy.day13.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.ymy.day13.R;
import com.bw.ymy.day13.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends  RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private List<UserBean.DataBean> mdatas;
    private Context mcontext;

    public GridAdapter(Context context) {
        mcontext=context;
        mdatas=new ArrayList<>();
    }
    public  void  addItem(List<UserBean.DataBean> datas)
    {

        if(datas!=null)
        {
            mdatas.addAll(datas);
        }

        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        UserBean.DataBean user=mdatas.get(i);
        viewHolder.title.setText(user.getName());

        Glide.with(mcontext).load(user.getIcon()).into(viewHolder.imageView);
            viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mClick!=null)
                    {
                        mClick.OnClick(i);
                    }
                }
            });
        viewHolder.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                if(mClick!=null)
                {
                    mClick.OnLongClick(i);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView title;
        // public final ImageView avatar;
        public final LinearLayout linearLayout;
       public  final ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.tv_recycle_grid);

            linearLayout = v.findViewById(R.id.ll_recycle_grid);
            imageView=v.findViewById(R.id.iv_recycle_grid);
        }
    }
    // 移除数据

    public void removeData(int position) {
        mdatas.remove(position);
        //必须使用notifyItemRemoved 才能加载移除动画
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mdatas.size());
    }

    //添加
    public  void addData(int position,UserBean.DataBean datas)
    {
        mdatas.add(position,datas);
        notifyDataSetChanged();

    }
    Click mClick;

    public void setClickListener(Click click){
        mClick = click;
    }

    public interface Click{
        void OnClick(int position);
        void OnLongClick(int position);
    }
}


