package com.kaiueo.atss;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by zhangke on 21/02/2018.
 */

public interface GetToken_interface {
    @GET("api/v1/auth/token")
    Call<Token> getCall(@Header("Authorization") String auth);

}
