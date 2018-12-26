package com.wangshen.base.AppContext;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wangshen.base.config.BaseUrl;
import com.wangshen.base.net.client.KRetrofitConfig;
import com.wangshen.base.net.client.KRetrofitFactory;
import com.wangshen.base.net.interceptor.ExCookieInterceptor;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/24 14:29
 * @change
 */
public class AppContext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
        KRetrofitConfig config = new KRetrofitConfig.Builder()
                .baseUrl(BaseUrl.BASEURL)
                .retryOnConnectionFailure(false)
                .setConnectTimeout(20)
                .setReadTimeout(20)
                .setWriteTimeout(20)
                .addInterceptor(new ExCookieInterceptor())
                .build();
        KRetrofitFactory.init(config);
    }
}
