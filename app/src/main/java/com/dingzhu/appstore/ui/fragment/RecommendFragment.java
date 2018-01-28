package com.dingzhu.appstore.ui.fragment;

import android.app.ProgressDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dingzhu.appstore.R;
import com.dingzhu.appstore.bean.AppInfo;
import com.dingzhu.appstore.di.component.AppComponent;
import com.dingzhu.appstore.di.component.DaggerRecommendComponent;
import com.dingzhu.appstore.di.module.RecommendModule;
import com.dingzhu.appstore.presenter.RecommendPresenter;
import com.dingzhu.appstore.presenter.contract.RecommendContract;
import com.dingzhu.appstore.ui.adapter.RecommendAppAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * @author wulimin
 * @function RecommendFragment 推荐
 * @time 2018/1/21 下午4:57
 */


public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.View {


    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private RecommendAppAdapter mRecommendAppAdapter;
    @Inject
    ProgressDialog mProgressDialog;


    @Override
    public int setLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void setupAcitivtyComponent(AppComponent appComponent) {
        DaggerRecommendComponent.builder()
                .recommendModule(new RecommendModule(this)).build().inject(this);
    }

    @Override
    public void init() {
        mPresenter.requestDatas();
    }


    private void initRecyclerView(List<AppInfo> datas) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
        mRecommendAppAdapter = new RecommendAppAdapter(getActivity(), datas);
        mRecyclerView.setAdapter(mRecommendAppAdapter);
    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void dissmisLoading() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showResult(List<AppInfo> datas) {
        initRecyclerView(datas);
    }

    @Override
    public void showNodata() {
        Toast.makeText(getActivity(), "暂时无数据", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(), "服务器开小差了" + msg, Toast.LENGTH_SHORT).show();
    }
}
