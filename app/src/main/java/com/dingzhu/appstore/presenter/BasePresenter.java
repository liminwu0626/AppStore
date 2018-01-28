package com.dingzhu.appstore.presenter;

import com.dingzhu.appstore.ui.BaseView;

/**
 * Created by wulimin on 2018/1/25.
 */

public class BasePresenter<M, V extends BaseView> {

    protected M mModel;

    protected V mView;

    public BasePresenter(M m, V v) {
        this.mModel = m;
        this.mView = v;
    }
}
