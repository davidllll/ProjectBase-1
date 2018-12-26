package com.wangshen.base.ui.mvp.base.view;

import android.content.Intent;

import com.wangshen.base.ui.mvp.base.presenter.BasePresenter;

/**
 * @name ProjectBase
 * @class describe
 * @anthor 王文章
 * @time 2018/10/31 10:22
 * @change
 */
public interface BaseView {
    /**
     * 显示加载框
     */
    void showLoadingDialog();

    /**
     * 隐藏加载狂
     */
    void hideLoadingDialog();

    /**
     * 提示信息
     * @param msg
     */
    void showMessage(String msg);
    /**
     * 关闭页面
     */
    void finishActivity();

    /**
     * 关闭页面并返回结果
     */
    void finishActivityForResult(int resultCode, Intent data);
}
