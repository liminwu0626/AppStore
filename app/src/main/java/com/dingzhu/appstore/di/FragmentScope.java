package com.dingzhu.appstore.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
* @function FragmentScope
* @author wulimin
* @time 2018/1/28 下午6:41
*/


@Scope
@Documented
@Retention(RUNTIME)
public @interface FragmentScope {
}
