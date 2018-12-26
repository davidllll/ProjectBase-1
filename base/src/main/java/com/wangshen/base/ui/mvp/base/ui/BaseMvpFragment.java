package com.wangshen.base.ui.mvp.base.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.wangshen.base.dialog.base.BaseDialog;
import com.wangshen.base.ui.mvp.base.presenter.BasePresenter;
import com.wangshen.base.ui.mvp.base.view.BaseView;
import com.wangshen.base.util.ToastUtils;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/24 10:06
 * @change
 */
public abstract class BaseMvpFragment <P extends BasePresenter> extends BaseFragment implements BaseView{
    protected P presenter;
    @SuppressWarnings("unchecked")
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter=getPresenter();
        presenter.attchView(this);
    }

    @Override
    public void hideLoadingDialog() {
        mContext.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (dialog != null && dialog.isShowing() && !mContext.isFinishing()){
                    dialog.dismiss();
                }
            }
        });
    }

    @Override
    public void showMessage(String msg) {
        ToastUtils.showToast(mContext,msg);
    }

    @Override
    public void showLoadingDialog() {
        mContext.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (dialog != null && !dialog.isShowing() && !mContext.isFinishing()){
                    dialog.show();
                }
            }
        });
    }
    public abstract P getPresenter();
}
