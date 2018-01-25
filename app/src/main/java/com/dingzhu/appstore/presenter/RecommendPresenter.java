package com.dingzhu.appstore.presenter;

import com.dingzhu.appstore.bean.AppInfo;
import com.dingzhu.appstore.bean.PageBean;
import com.dingzhu.appstore.data.RecommendModel;
import com.dingzhu.appstore.presenter.contract.RecommendContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wulimin on 2018/1/25.
 */

public class RecommendPresenter implements RecommendContract.Presenter {
    private RecommendContract.View mView;
    private RecommendModel mRecommendModel;

    public RecommendPresenter(RecommendContract.View view) {
        mView = view;
        mRecommendModel = new RecommendModel();
    }

    @Override
    public void requestData() {
        mView.showLoading();
        mRecommendModel.getApps(new Callback<PageBean<AppInfo>>() {
            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {
                if (response != null) {
                    mView.showResult(response.body().getDatas());
                } else {
                    mView.showNoData();
                }
                mView.dissmisLoading();
            }

            @Override
            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {
                mView.showError(t.getMessage());
                mView.dissmisLoading();
            }
        });
    }
}
