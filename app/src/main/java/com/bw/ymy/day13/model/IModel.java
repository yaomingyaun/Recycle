package com.bw.ymy.day13.model;

import com.bw.ymy.day13.callback.MyCallBack;

import java.util.Map;

public interface IModel {
    void getRequest(String dataUrl, Map<String,String> params, Class clazz, MyCallBack callBack);
}
