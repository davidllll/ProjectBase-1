package com.wangshen.base.ui.mvp.base.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wangshen.base.dialog.base.BaseDialog;
import com.wangshen.base.ui.mvp.base.presenter.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @name ProjectBase
 * @class describe
 * @anthor 王文章
 * @time 2018/10/31 10:23
 * @change
 */
public abstract class BaseActivity extends Activity{
    protected BaseDialog dialog;
    protected Context mContext=this;
    protected String TGA=getClass().getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        ButterKnife.bind(this);
        dialog=getDialog();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getData();
        initView();
        initLinsenterner();
    }

    public abstract int getView();
    public abstract BaseDialog getDialog();
    public abstract void initView();
    public abstract void initLinsenterner();
    public abstract void getData();
}
