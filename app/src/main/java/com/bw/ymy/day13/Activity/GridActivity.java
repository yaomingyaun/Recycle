package com.bw.ymy.day13.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bw.ymy.day13.Apks;
import com.bw.ymy.day13.DividerGridItemDecoration;
import com.bw.ymy.day13.R;
import com.bw.ymy.day13.adapter.GridAdapter;
import com.bw.ymy.day13.bean.UserBean;
import com.bw.ymy.day13.presenter.IPensenterImpl;
import com.bw.ymy.day13.view.IView;

import java.util.HashMap;

public class GridActivity extends AppCompatActivity implements IView {
    private GridAdapter gridAdapter;
    private IPensenterImpl iPensenter;
    private Button button_recycler_grid_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取资源id
        setContentView(R.layout.activity_grid);
        button_recycler_grid_add=findViewById(R.id.button_recycler_grid_add);
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        //实列化
        iPensenter=new IPensenterImpl(this);

        //创建布局管理
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        //设置方向
        layoutManager.setOrientation(OrientationHelper.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
            //设置适配器
        gridAdapter = new GridAdapter(this);
        recyclerView.setAdapter(gridAdapter);

        iPensenter.getRequest(Apks.TYPE_IMAGE,new HashMap<String, String>(),UserBean.class);
        //设置分割线
        DividerGridItemDecoration dividerGridItemDecoration = new DividerGridItemDecoration(this);
        recyclerView.addItemDecoration(dividerGridItemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //点击事件
        gridAdapter.setClickListener(new GridAdapter.Click() {
            //点击删除
            @Override
            public void OnClick(int position) {
                Log.i("dj", "OnClick in activity " + position);
                gridAdapter.removeData(position);
            }

            @Override
            public void OnLongClick(int position) {
                Log.i("dj", "OnLongClick in activity " + position);
            }
        });
        //添加
        button_recycler_grid_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserBean.DataBean dataBean = new UserBean.DataBean();
                dataBean.setName("天猫");
                gridAdapter.addData(0,dataBean);
            }
        });
    }
    @Override
    public void onsuccess(Object data) {
        if(data instanceof UserBean){
            UserBean usersBean= (UserBean) data;
            gridAdapter.addItem(usersBean.getData());

        }

    }
}
