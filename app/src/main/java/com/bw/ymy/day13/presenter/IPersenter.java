package com.bw.ymy.day13.presenter;

import java.util.Map;

public interface IPersenter {
    void getRequest(String dataUrl, Map<String,String> params, Class clazz);
}
