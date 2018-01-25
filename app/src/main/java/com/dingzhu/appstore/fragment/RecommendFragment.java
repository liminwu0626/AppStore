package com.dingzhu.appstore.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dingzhu.appstore.R;
import com.dingzhu.appstore.bean.AppInfo;
import com.dingzhu.appstore.presenter.RecommendPresenter;
import com.dingzhu.appstore.presenter.contract.RecommendContract;
import com.dingzhu.appstore.ui.adapter.RecommendAppAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wulimin
 * @function RecommendFragment 推荐
 * @time 2018/1/21 下午4:57
 */


public class RecommendFragment extends Fragment implements RecommendContract.View {


    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    private RecommendAppAdapter mRecommendAppAdapter;
    private RecommendPresenter mPresenter;
    protected ProgressDialog mProgressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recommend, null, false);
        unbinder = ButterKnife.bind(this, rootView);
        mPresenter = new RecommendPresenter(this);
        mProgressDialog = new ProgressDialog(getActivity());
        initData();
        return rootView;
    }

    private void initData() {
        mPresenter.requestData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
    public void showNoData() {
        Toast.makeText(getActivity(), "暂时无数据", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(), "服务器开小差了" + msg, Toast.LENGTH_SHORT).show();
    }
}
