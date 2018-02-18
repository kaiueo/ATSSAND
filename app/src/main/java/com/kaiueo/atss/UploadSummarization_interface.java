package com.kaiueo.atss;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by zhangke on 18/02/2018.
 */

public interface UploadSummarization_interface {
    @POST("api/v1/article/upload")
    Call<UploadResult> getCall(@Header("Authorization") String auth, @Body PostUpload post);

}
