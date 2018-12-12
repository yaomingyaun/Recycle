package com.bw.ymy.day13.Activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.bw.ymy.day13.Apks;
import com.bw.ymy.day13.R;
import com.bw.ymy.day13.adapter.LinearAdapter;
import com.bw.ymy.day13.bean.UserBean;
import com.bw.ymy.day13.presenter.IPensenterImpl;
import com.bw.ymy.day13.view.IView;

import java.util.HashMap;

public class LinearActivity extends AppCompatActivity implements IView {

    private LinearAdapter linearAdapter;
    private RecyclerView recyclerView;
    private IPensenterImpl iPensenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        //获取资源id
        recyclerView=findViewById(R.id.recyclerview);
        iPensenter=new IPensenterImpl(this);
        //布局管理
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        //设置方向
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置布局管理
        recyclerView.setLayoutManager(layoutManager);
        //适配器
        linearAdapter =new LinearAdapter(this);
        recyclerView.setAdapter(linearAdapter);
        //
        iPensenter.getRequest(Apks.TYPE_IMAGE,new HashMap<String, String>(),UserBean.class);

        //分割线
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this,R.drawable.recycler_divider_horizontal));
        //的动画
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onsuccess(Object data) {
        if(data instanceof  UserBean)
        {
            UserBean userBean= (UserBean) data;
            linearAdapter.addItem(userBean.getData());
        }
    }
}
