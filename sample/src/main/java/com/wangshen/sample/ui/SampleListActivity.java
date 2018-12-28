package com.wangshen.sample.ui;

import android.content.Intent;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wangshen.base.app.AppActivityKey;
import com.wangshen.base.dialog.base.BaseDialog;
import com.wangshen.base.ui.mvp.base.adapter.BaseAdapter;
import com.wangshen.base.ui.mvp.base.refresh.BaseRecyclerListActivity;
import com.wangshen.sample.R;
import com.wangshen.sample.SampleAdapter;
import com.wangshen.sample.SampleBean;
import com.wangshen.sample.dialog.SampleDialog;
import com.wangshen.sample.presenter.SampleListContact;
import com.wangshen.sample.presenter.SampleListPresenterImp;

import java.util.ArrayList;


/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/24 16:10
 * @change
 */
@Route(path = AppActivityKey.SAMPLELIST_ACTIVITY)
public class SampleListActivity extends BaseRecyclerListActivity<SampleListPresenterImp> implements SampleListContact.View{
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
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {
        presenter.getSampleData("123");
    }

    @Override
    public SampleListPresenterImp getPresenter() {
        return new SampleListPresenterImp();
    }

    @Override
    public void loadData() {
        presenter.getSampleData("123");
    }

    @Override
    public BaseAdapter createRecyclerAdapter() {
        return new SampleAdapter(R.layout.item_sample,new ArrayList<SampleBean.ResultBean>());
    }

}
