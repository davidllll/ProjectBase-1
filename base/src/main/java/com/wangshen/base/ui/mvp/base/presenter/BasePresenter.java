package com.wangshen.base.ui.mvp.base.presenter;

import com.wangshen.base.net.bean.ExBaseEntity;
import com.wangshen.base.net.transformer.KResponseTransformer;
import com.wangshen.base.ui.mvp.base.ui.BaseActivity;
import com.wangshen.base.ui.mvp.base.view.BaseView;
import com.wangshen.base.ui.mvp.base.view.ExRxBasePresenter;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @name ProjectBase
 * @class describe
 * @anthor 王文章
 * @time 2018/10/31 10:22
 * @change
 */
public class BasePresenter<V extends BaseView> implements ExRxBasePresenter{
    private CompositeDisposable mCompositeDisposable;
    private WeakReference<V> view;
    public  void attchView(V view) {
        this.view = new WeakReference<>(view);
    }
    public void detachView(){
        if (view != null) {
            view.clear();
            view = null;
        }
        unDisposable();
    }



    public boolean isViewAttached() {
        return view != null && view.get() != null;
    }



    public V getView() {
        return view != null ? view.get() : null;
    }
    @Override
    public void addDisposable(Disposable subscription) {
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

    @Override
    public void unDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }

    @Override
    public <T extends ExBaseEntity> ObservableTransformer<T, T> handleEverythingResult() {
        return handleEverythingResult(true);
    }

    @Override
    public <T extends ExBaseEntity> ObservableTransformer<T, T> handleEverythingResult(final String loadingMessage) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return handleCommon(upstream, true, loadingMessage)
                        .flatMap(new KResponseTransformer.ResponseFunction<T>());
            }
        };
    }

    @Override
    public <T extends ExBaseEntity> ObservableTransformer<T, T> handleEverythingResult(final boolean showLoading) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return handleCommon(upstream, showLoading, null)
                        .flatMap(new KResponseTransformer.ResponseFunction<T>());
            }
        };
    }

    @Override
    public <T extends ExBaseEntity> ObservableTransformer<T, T> handleOnlyNetworkResult() {
        return handleOnlyNetworkResult(true);
    }

    @Override
    public <T extends ExBaseEntity> ObservableTransformer<T, T> handleOnlyNetworkResult(final String loadingMessage) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return handleCommon(upstream, true, loadingMessage);
            }
        };
    }

    @Override
    public <T extends ExBaseEntity> ObservableTransformer<T, T> handleOnlyNetworkResult(final boolean showLoading) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return handleCommon(upstream, showLoading, null);
            }
        };
    }

    private <T extends ExBaseEntity> Observable<T> handleCommon(Observable<T> upstream, final boolean showLoading, final String loadingMessage) {
        return upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new KResponseTransformer.ErrorResumeFunction<T>())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (isViewAttached() && showLoading) {
                            getView().showLoadingDialog();
                        }
                        addDisposable(disposable);
                    }
                })
                .doOnNext(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        if (isViewAttached() && showLoading) {
                            getView().hideLoadingDialog();
                        }
                    }
                })
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (isViewAttached() && showLoading) {
                            getView().hideLoadingDialog();
                        }
                    }
                });
        }

}
