package com.wangshen.sample.presenter;

import com.wangshen.base.net.bean.BaseAppEntity;
import com.wangshen.base.ui.mvp.base.presenter.BasePresenter;
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
public class SamplePresenterImp extends BasePresenter<SampleContact.View> implements SampleContact.Presenter{
    private SampleDataSource sampleDataSource;
    public SamplePresenterImp() {
        sampleDataSource=new SampleDataSource();
    }

    @Override
    public void getSampleData(String code) {
        sampleDataSource.sampleRequest(code)
                .compose(this.<BaseAppEntity<SampleBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<SampleBean>>() {
                    @Override
                    public void accept(BaseAppEntity<SampleBean> sampleBeanBaseAppEntity) throws Exception {
                        getView().getSampleData(sampleBeanBaseAppEntity.getContent());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
