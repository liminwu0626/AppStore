package com.dingzhu.appstore.presenter;

import com.dingzhu.appstore.bean.AppInfo;
import com.dingzhu.appstore.bean.PageBean;
import com.dingzhu.appstore.data.RecommendModel;
import com.dingzhu.appstore.presenter.contract.RecommendContract;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wulimin on 2018/1/25.
 */

public class RecommendPresenter extends BasePresenter<RecommendModel, RecommendContract.View> {

    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view) {
        super(model, view);
    }


    public void requestDatas() {

        mView.showLoading();

        mModel.getApps(new Callback<PageBean<AppInfo>>() {
            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {

                if (response != null) {

                    mView.showResult(response.body().getDatas());
                } else {
                    mView.showNodata();
                }

                mView.dissmisLoading();

            }

            @Override
            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {

                mView.dissmisLoading();
                mView.showError(t.getMessage());

            }
        });
    }
}
