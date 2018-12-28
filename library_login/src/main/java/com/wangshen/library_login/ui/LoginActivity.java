package com.wangshen.library_login.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wangshen.base.dialog.base.BaseDialog;
import com.wangshen.base.ui.mvp.base.presenter.BasePresenter;
import com.wangshen.base.ui.mvp.base.ui.BaseMvpActivity;
import com.wangshen.library_login.R;
import com.wangshen.library_login.presenter.LoginContact;
import com.wangshen.library_login.presenter.LoginPresenter;

public class LoginActivity extends BaseMvpActivity implements LoginContact.View{


    @Override
    public BasePresenter getPresenter() {
        return new LoginPresenter();
    }

    @Override
    public int getView() {
        return R.layout.activity_login;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }

    @Override
    public void finishActivity() {

    }

    @Override
    public void finishActivityForResult(int resultCode, Intent data) {

    }
}
