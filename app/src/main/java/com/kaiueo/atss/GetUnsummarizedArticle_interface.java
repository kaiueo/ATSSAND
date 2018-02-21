package com.kaiueo.atss;

/**
 * Created by zhangke on 18/02/2018.
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;


public interface GetUnsummarizedArticle_interface {

    @GET("api/v1/article/get")
    Call<UnsummarizedArticle> getCall(@Header("Authorization") String auth);
}
