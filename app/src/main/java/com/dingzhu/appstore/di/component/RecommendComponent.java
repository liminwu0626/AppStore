package com.dingzhu.appstore.di.component;

import com.dingzhu.appstore.di.FragmentScope;
import com.dingzhu.appstore.di.module.RecommendModule;
import com.dingzhu.appstore.ui.fragment.RecommendFragment;

import dagger.Component;

/**
 * @author wulimin
 * @function RecommendComponent
 * @time 2018/1/28 下午6:41
 */


@FragmentScope
@Component(modules = RecommendModule.class, dependencies = AppComponent.class)
public interface RecommendComponent {

    void inject(RecommendFragment fragment);
}
