package com.wangshen.sample.data;

;

import com.wangshen.base.net.bean.BaseAppEntity;
import com.wangshen.base.net.client.KRetrofitFactory;
import com.wangshen.sample.SampleBean;
import com.wangshen.sample.service.SampleApi;

import java.util.HashMap;

import io.reactivex.Observable;


/**
 * description：
 * <p>
 * author： DS.Hu
 * <p>
 * time： 2018/7/23 19:07
 * <p>
 */
public class SampleDataSource {

    public Observable<BaseAppEntity<SampleBean>> sampleRequest(String code) {
        return KRetrofitFactory.createService(SampleApi.class)
                .sampleRequest(code);
    }

}
