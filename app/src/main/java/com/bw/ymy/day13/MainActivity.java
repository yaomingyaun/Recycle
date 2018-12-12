package com.bw.ymy.day13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bw.ymy.day13.Activity.GridActivity;
import com.bw.ymy.day13.Activity.LinearActivity;
import com.bw.ymy.day13.Activity.StageActivity;

public class MainActivity extends AppCompatActivity {
    private Button linear,grid,stage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取资源id
        linear=findViewById(R.id.linear);
        grid=findViewById(R.id.grid);
        stage=findViewById(R.id.stage);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LinearActivity.class);
                startActivity(intent);
            }
        });
        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GridActivity.class);
                startActivity(intent);
            }
        });
        stage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,StageActivity.class);
                startActivity(intent);
            }
        });

    }
}
