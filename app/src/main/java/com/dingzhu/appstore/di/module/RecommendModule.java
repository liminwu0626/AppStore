package com.dingzhu.appstore.di.module;

import android.app.ProgressDialog;

import com.dingzhu.appstore.data.RecommendModel;
import com.dingzhu.appstore.data.http.ApiService;
import com.dingzhu.appstore.presenter.contract.RecommendContract;
import com.dingzhu.appstore.ui.fragment.RecommendFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wulimin on 2018/1/25.
 */
@Module
public class RecommendModule {
    private RecommendContract.View mView;

    public RecommendModule(RecommendContract.View view) {
        mView = view;
    }

    @Provides
    public RecommendContract.View provideView() {
        return mView;
    }

    @Provides
    public ProgressDialog provideProgressDialog(RecommendContract.View view) {
        return new ProgressDialog(((RecommendFragment) view).getActivity());
    }

    @Provides
    public RecommendModel provideModel(ApiService apiService) {
        return new RecommendModel(apiService);
    }
}
