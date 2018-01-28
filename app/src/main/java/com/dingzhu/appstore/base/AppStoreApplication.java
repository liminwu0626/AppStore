package com.dingzhu.appstore.base;

import android.app.Application;
import android.content.Context;

import com.dingzhu.appstore.di.component.AppComponent;
import com.dingzhu.appstore.di.component.DaggerAppComponent;
import com.dingzhu.appstore.di.module.AppModule;
import com.dingzhu.appstore.di.module.HttpModule;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * Created by wulimin on 2018/1/21.
 */

public class AppStoreApplication extends Application {

    private AppComponent mAppComponent;

    public static AppStoreApplication get(Context context) {
        return (AppStoreApplication) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)
                .methodCount(2)
                .methodOffset(7)
                .tag("手机助手")
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this))
                .httpModule(new HttpModule()).build();
    }
}
