package com.kaiueo.atss;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by zhangke on 18/02/2018.
 */

public interface GetSummaryFromUrl_interface {
    @POST("api/v1/summary/")
    Call<SummarizedArticle> getCall(@Header("Authorization") String auth, @Body PostSummayFromUrl post);

}
