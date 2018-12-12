package com.bw.ymy.day13.Activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.bw.ymy.day13.Apks;
import com.bw.ymy.day13.R;
import com.bw.ymy.day13.adapter.LinearAdapter;
import com.bw.ymy.day13.adapter.StatgeAdapter;
import com.bw.ymy.day13.bean.UserBean;
import com.bw.ymy.day13.presenter.IPensenterImpl;
import com.bw.ymy.day13.view.IView;

import java.util.HashMap;

public class StageActivity extends AppCompatActivity implements IView {
    private StatgeAdapter statgeAdapter;
    private IPensenterImpl iPensenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);
        setContentView(R.layout.activity_linear);
        //获取资源id
        recyclerView=findViewById(R.id.recyclerview);
        iPensenter=new IPensenterImpl(this);
        //布局管理   第一个参数 一行几个
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        //设置布局管理
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        //适配器
        statgeAdapter =new StatgeAdapter(this);
        recyclerView.setAdapter(statgeAdapter);
        //
        iPensenter.getRequest(Apks.TYPE_IMAGE,new HashMap<String, String>(),UserBean.class);

        // 系统分割线
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        //自己创建的分割线
       // dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this,R.drawable.recycler_divider_horizontal));
        recyclerView.addItemDecoration(dividerItemDecoration);
        //设置增加或者删除
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    @Override
    public void onsuccess(Object data) {

        if(data instanceof  UserBean)
        {
            UserBean userBean= (UserBean) data;
            statgeAdapter.addItem(userBean.getData());

        }
    }
}
