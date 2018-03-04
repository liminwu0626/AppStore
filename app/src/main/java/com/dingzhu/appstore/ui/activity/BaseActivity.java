package com.dingzhu.appstore.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dingzhu.appstore.base.AppStoreApplication;
import com.dingzhu.appstore.di.component.AppComponent;
import com.dingzhu.appstore.presenter.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wulimin on 2018/3/4.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    private Unbinder mUnbinder;
    private AppStoreApplication mAppStoreApplication;
    @Inject
    T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        mUnbinder = ButterKnife.bind(this);
        this.mAppStoreApplication = (AppStoreApplication) getApplication();
        setupActivityCompontent(mAppStoreApplication.getAppComponent());
        init();
    }

    public abstract int setLayout();

    public abstract void init();

    public abstract void setupActivityCompontent(AppComponent appComponent);

    protected void startActivity(Class c) {
        this.startActivity(new Intent(this, c));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
    }
}
