package com.bw.ymy.day13.model;

import com.bw.ymy.day13.callback.MyCallBack;
import com.bw.ymy.day13.okhttp.ICallBack;
import com.bw.ymy.day13.okhttp.OKhttpUtils;

import java.util.Map;

public class IModelImpl implements IModel {
    @Override
    public void getRequest(String dataUrl, Map<String, String> params, Class clazz, final MyCallBack callBack) {
        OKhttpUtils.getInstance().postEnqueue(dataUrl, params, clazz, new ICallBack() {
            @Override
            public void onSuccess(Object obj) {
                callBack.onsuccess(obj);
            }

            @Override
            public void onFail(Exception e) {
        callBack.onsuccess(e);
            }
        });
    }
}
