package com.example.a86066.appverticaltablayout.model;

import com.example.a86066.appverticaltablayout.api.MainService;
import com.example.a86066.appverticaltablayout.bean.DetailsBean;
import com.example.a86066.appverticaltablayout.collback.Collback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsModel {
    public void getmodel(int id, final Collback<DetailsBean, String> collback) {

        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(MainService.mainurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<DetailsBean> observable = retrofit.create(MainService.class)
                .getdetailsservice(id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DetailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DetailsBean detailsBean) {
                        collback.succeed(detailsBean);
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
