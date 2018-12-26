package com.wangshen.sample.presenter;

import com.wangshen.base.ui.mvp.base.refresh.BaseRecyclerListContact;
import com.wangshen.base.ui.mvp.base.view.BaseView;
import com.wangshen.sample.SampleBean;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/24 14:05
 * @change
 */
public class SampleListContact {
   public interface Presenter{
        void getSampleData(String m);
    }
   public interface View extends BaseRecyclerListContact.View{
        //void getSampleData(SampleBean sampleBean);
    }
}
