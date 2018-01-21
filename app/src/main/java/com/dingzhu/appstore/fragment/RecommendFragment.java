package com.dingzhu.appstore.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dingzhu.appstore.R;

/**
 * @author wulimin
 * @function RecommendFragment 推荐
 * @time 2018/1/21 下午4:57
 */


public class RecommendFragment extends Fragment {

    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_recommend, null, false);
        return mRootView;
    }
}
