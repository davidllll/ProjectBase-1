package com.wangshen.sample.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wangshen.base.app.AppActivityKey;
import com.wangshen.base.dialog.base.BaseDialog;
import com.wangshen.base.ui.mvp.base.ui.BaseMvpActivity;
import com.wangshen.base.util.ToastUtils;
import com.wangshen.sample.R;
import com.wangshen.sample.R2;
import com.wangshen.sample.SampleBean;
import com.wangshen.sample.dialog.SampleDialog;
import com.wangshen.sample.presenter.SampleContact;
import com.wangshen.sample.presenter.SamplePresenterImp;
import com.wangshen.sample.presenter.SampleRefreshContact;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = AppActivityKey.SAMPLE_ACTIVITY)
public class SampleActivity extends BaseMvpActivity<SamplePresenterImp> implements SampleContact.View {

    @BindView(R2.id.sample_bt1)
    Button sampleBt1;
    @BindView(R2.id.sample_bt2)
    Button sampleBt2;
    @BindView(R2.id.sample_bt3)
    Button sampleBt3;


    @Override
    public SamplePresenterImp getPresenter() {
        return new SamplePresenterImp();
    }

    @Override
    public int getView() {
        return R.layout.activity_main;
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
    public void finishActivity() {
        finish();
    }

    @Override
    public void finishActivityForResult(int resultCode, Intent data) {

    }

    @Override
    public void getSampleData(final SampleBean sampleBean) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToast(mContext,"取到了="+sampleBean.getResult().size()+"条数据");
            }
        });
        Log.e(TGA,"取到了="+sampleBean.getResult().size()+"条数据");
    }

    @OnClick({R2.id.sample_bt1, R2.id.sample_bt2, R2.id.sample_bt3})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.sample_bt1) {
            presenter.getSampleData("123");
        } else if (i == R.id.sample_bt2) {
            startActivity(new Intent(this,SampleListActivity.class));
            ARouter.getInstance().build(AppActivityKey.SAMPLELIST_ACTIVITY,"123").navigation(this, new NavigationCallback() {
                @Override
                public void onFound(Postcard postcard) {
                    Log.e(TGA, "onArrival: 找到了 ");
                }

                @Override
                public void onLost(Postcard postcard) {
                    Log.e(TGA, "onArrival: 找不到了 ");
                }

                @Override
                public void onArrival(Postcard postcard) {

                }

                @Override
                public void onInterrupt(Postcard postcard) {

                }
            });
        } else if (i == R.id.sample_bt3) {
            startActivity(new Intent(this,SampleRefreshActivity.class));
        }
    }

}
