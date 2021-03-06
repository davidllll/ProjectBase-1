package com.wangshen.base.dialog.base;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;

/**
 * @name ProjectBase
 * @class describe
 * @anthor 王文章
 * @time 2018/10/31 10:32
 * @change
 */
public abstract class BaseDialog extends Dialog {
    public BaseDialog(@NonNull Context context) {
        super(context);
        setContentView(getView());
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        getWindow().setGravity(Gravity.CENTER);
        initData();
        initView();
    }
    public abstract void initView();

    public abstract void initData();

    public abstract int getView();
}
