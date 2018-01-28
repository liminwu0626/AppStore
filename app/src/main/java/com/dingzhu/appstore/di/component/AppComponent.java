package com.dingzhu.appstore.di.component;

import com.dingzhu.appstore.data.http.ApiService;
import com.dingzhu.appstore.di.module.AppModule;
import com.dingzhu.appstore.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by wulimin on 2018/1/28.
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    public ApiService getApiservice();
}
