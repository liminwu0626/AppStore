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
 * @function GamesFragment 游戏
 * @time 2018/1/21 下午4:58
 */


public class GamesFragment extends Fragment {

    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_games, null, false);
        return mRootView;
    }
}
