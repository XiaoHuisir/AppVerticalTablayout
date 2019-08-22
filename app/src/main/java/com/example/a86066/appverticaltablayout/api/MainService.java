package com.example.a86066.appverticaltablayout.api;

import com.example.a86066.appverticaltablayout.bean.MainBean;
import com.example.a86066.appverticaltablayout.bean.DetailsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainService {
    /*
     * tablayout
     * */
    //    https://cdwan.cn/api/catalog/index
    String mainurl = "https://cdwan.cn/api/";

    @GET("catalog/index")
    Observable<MainBean> gettbservice();

    /*
     * 详情
     * */
    //    https://cdwan.cn/api/catalog/current
    @GET("catalog/current")
    Observable<DetailsBean> getdetailsservice(@Query("id") int id);
}
