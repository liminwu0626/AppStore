package com.dingzhu.appstore.http;

import com.dingzhu.appstore.bean.AppInfo;
import com.dingzhu.appstore.bean.PageBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wulimin on 2018/1/24.
 */

public interface ApiService {
    public static final String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";

    @GET("featured")
    public Call<PageBean<AppInfo>> getApps(@Query("p") String jsonParams);

}
