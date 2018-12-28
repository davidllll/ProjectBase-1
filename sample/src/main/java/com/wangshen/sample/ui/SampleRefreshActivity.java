package com.wangshen.sample.ui;

import android.content.Intent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wangshen.base.app.AppActivityKey;
import com.wangshen.base.dialog.base.BaseDialog;
import com.wangshen.base.ui.mvp.base.adapter.BaseAdapter;
import com.wangshen.base.ui.mvp.base.refresh.BaseRecyclerRefreshActivity;
import com.wangshen.sample.R;
import com.wangshen.sample.SampleAdapter;
import com.wangshen.sample.SampleBean;
import com.wangshen.sample.dialog.SampleDialog;
import com.wangshen.sample.presenter.SampleRefreshPresenterImp;

import java.util.ArrayList;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/26 9:14
 * @change
 */
@Route(path = AppActivityKey.SAMPLEREFESH_ACTIVITY)
public class SampleRefreshActivity extends BaseRecyclerRefreshActivity<SampleRefreshPresenterImp> {
    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void finishActivityForResult(int resultCode, Intent data) {

    }

    @Override
    public BaseDialog getDialog() {
        return new SampleDialog(this);
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
    public SampleRefreshPresenterImp getPresenter() {
        return new SampleRefreshPresenterImp();
    }

    @Override
    public BaseAdapter createRecyclerAdapter() {
        return new SampleAdapter(R.layout.item_sample,new ArrayList<SampleBean.ResultBean>());
    }
}
