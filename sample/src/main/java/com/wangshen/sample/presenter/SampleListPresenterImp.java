package com.wangshen.sample.presenter;

import com.wangshen.base.net.bean.BaseAppEntity;

import com.wangshen.base.ui.mvp.base.refresh.BaseRecyclerListPresenter;

import com.wangshen.base.ui.mvp.base.refresh.RequestCallback;
import com.wangshen.sample.SampleBean;
import com.wangshen.sample.data.SampleDataSource;

import io.reactivex.functions.Consumer;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/24 14:04
 * @change
 */
public class SampleListPresenterImp extends BaseRecyclerListPresenter<SampleListContact.View,SampleBean.ResultBean> implements SampleContact.Presenter{
    private SampleDataSource sampleDataSource;
    public SampleListPresenterImp() {
        sampleDataSource=new SampleDataSource();
    }

    @Override
    public void getSampleData(String m) {
        sampleDataSource.sampleRequest(m)
                .compose(this.<BaseAppEntity<SampleBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<SampleBean>>() {
                    @Override
                    public void accept(BaseAppEntity<SampleBean> sampleBeanBaseAppEntity) throws Exception {
                        getCallback().onSuccess(sampleBeanBaseAppEntity.getContent().getResult());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getCallback().onFail(throwable.getMessage());
                    }
                });
    }

}
