package com.example.a86066.appverticaltablayout.model;

import com.example.a86066.appverticaltablayout.api.MainService;
import com.example.a86066.appverticaltablayout.bean.MainBean;
import com.example.a86066.appverticaltablayout.collback.Collback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TbModel {
    public void getmodel(final Collback<MainBean, String> collback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainService.mainurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<MainBean> gettbservice = retrofit.create(MainService.class).gettbservice();
        gettbservice.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MainBean mainBean) {
                        collback.succeed(mainBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        collback.isEnit("请求失败" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
