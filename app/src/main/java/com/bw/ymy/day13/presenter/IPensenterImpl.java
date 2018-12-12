package com.bw.ymy.day13.presenter;

import com.bw.ymy.day13.callback.MyCallBack;
import com.bw.ymy.day13.model.IModelImpl;
import com.bw.ymy.day13.view.IView;

import java.util.Map;

public class IPensenterImpl implements IPersenter {

    private IView mIView;
    private IModelImpl iModel;

    public IPensenterImpl(IView mIView) {
        this.mIView = mIView;
        iModel=new IModelImpl();
    }
    public void deteach(){
        iModel=null;
        mIView=null;
    }
    @Override
    public void getRequest(String dataUrl, Map<String, String> params, Class clazz) {
            iModel.getRequest(dataUrl, params, clazz, new MyCallBack() {
                @Override
                public void onsuccess(Object data) {
                    mIView.onsuccess(data);
                }
            });
    }
}
