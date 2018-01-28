package com.dingzhu.appstore.di.module;

import com.dingzhu.appstore.base.AppStoreApplication;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wulimin on 2018/1/28.
 */
@Module
public class AppModule {
    private AppStoreApplication mAppStoreApplication;

    public AppModule(AppStoreApplication appStoreApplication) {
        mAppStoreApplication = appStoreApplication;
    }

    @Provides
    @Singleton
    public AppStoreApplication provideApplication() {
        return mAppStoreApplication;
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new Gson();
    }
}
