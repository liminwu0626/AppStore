package com.dingzhu.appstore.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dingzhu.appstore.ui.bean.FragmentInfo;
import com.dingzhu.appstore.ui.fragment.CategoryFragment;
import com.dingzhu.appstore.ui.fragment.GamesFragment;
import com.dingzhu.appstore.ui.fragment.RankingFragment;
import com.dingzhu.appstore.ui.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wulimin on 2018/1/21.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    List<FragmentInfo> mFragmentInfos = new ArrayList<>(4);

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }

    private void initFragments() {
        mFragmentInfos.add(new FragmentInfo("推荐", RecommendFragment.class));
        mFragmentInfos.add(new FragmentInfo("排行", RankingFragment.class));
        mFragmentInfos.add(new FragmentInfo("游戏", GamesFragment.class));
        mFragmentInfos.add(new FragmentInfo("分类", CategoryFragment.class));
    }


    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) mFragmentInfos.get(position).getFragment().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mFragmentInfos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentInfos.get(position).getTitle();
    }
}
