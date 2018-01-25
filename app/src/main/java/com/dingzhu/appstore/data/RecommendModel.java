package com.dingzhu.appstore.data;

import com.dingzhu.appstore.bean.AppInfo;
import com.dingzhu.appstore.bean.PageBean;
import com.dingzhu.appstore.http.ApiService;
import com.dingzhu.appstore.http.HttpManager;

import retrofit2.Callback;

/**
 * Created by wulimin on 2018/1/25.
 */

public class RecommendModel {
    public void getApps(Callback<PageBean<AppInfo>> callback) {
        HttpManager httpManager = new HttpManager();
        ApiService apiService = httpManager.getRetrofit(httpManager.getOkHttpClient()).create(ApiService.class);
        apiService.getApps("{'page':0}").enqueue(callback);
    }
}
