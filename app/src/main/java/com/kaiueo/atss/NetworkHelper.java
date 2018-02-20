package com.kaiueo.atss;

import android.util.Base64;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangke on 18/02/2018.
 */

public class NetworkHelper {

    private static String user = "aaa";
    private static String password = "aaaaaaa";

    private static String getBaseAuth(){
        String raw = user+":"+password;
        String authString = "Basic " + Base64.encodeToString(raw.getBytes(), Base64.NO_WRAP);
        return authString;
    }

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:5000/") // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
            .build();
    public static void getUserDetail(final SelfFragment fragment) {
        final GetUserDetail_interface request = retrofit.create(GetUserDetail_interface.class);
        Call<User> call = request.getCall(getBaseAuth());
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                System.out.print("chenggong");
                User user = response.body();
                fragment.change(user);


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("shibaiaaa");
                t.printStackTrace();
                System.out.print(t.getMessage());

            }
        });

    }

    public static void getUnsummarizedArticle(final UploadFragment fragment) {
        GetUnsummarizedArticle_interface request = retrofit.create(GetUnsummarizedArticle_interface.class);
        Call<UnsummarizedArticle> call = request.getCall();
        call.enqueue(new Callback<UnsummarizedArticle>() {
            @Override
            public void onResponse(Call<UnsummarizedArticle> call, Response<UnsummarizedArticle> response) {
                fragment.unsummarizedArticle = response.body();
                fragment.dialog.hide();
                fragment.showOrigin();
            }

            @Override
            public void onFailure(Call<UnsummarizedArticle> call, Throwable t) {
                System.out.println("asdadasd");
                t.printStackTrace();
                System.out.print(t.getMessage());
            }
        });

    }

    public static void getSummaryFromUrl(final SummaryFragment fragment, String url, int count) {
        GetSummaryFromUrl_interface request = retrofit.create(GetSummaryFromUrl_interface.class);
        PostSummayFromUrl post = new PostSummayFromUrl(1, url, count);
        Call<SummarizedArticle> call = request.getCall(getBaseAuth(), post);
        call.enqueue(new Callback<SummarizedArticle>() {
            @Override
            public void onResponse(Call<SummarizedArticle> call, Response<SummarizedArticle> response) {
                fragment.summarizedArticle = response.body();
                fragment.dialog.hide();
                fragment.showResult();
            }

            @Override
            public void onFailure(Call<SummarizedArticle> call, Throwable t) {
                fragment.summarizedArticle = null;
                fragment.dialog.hide();
                fragment.showResult();
                t.printStackTrace();
                System.out.print(t.getMessage());
            }
        });
    }

    public static void getSummaryFromText(final SummaryFragment fragment, String text, int count) {
        GetSummaryFromText_interface request = retrofit.create(GetSummaryFromText_interface.class);
        PostSummaryFromText post = new PostSummaryFromText(0, text, count);
        Call<SummarizedArticle> call = request.getCall(getBaseAuth(), post);
        call.enqueue(new Callback<SummarizedArticle>() {
            @Override
            public void onResponse(Call<SummarizedArticle> call, Response<SummarizedArticle> response) {
                fragment.summarizedArticle = response.body();
                fragment.dialog.hide();
                fragment.showResult();
            }

            @Override
            public void onFailure(Call<SummarizedArticle> call, Throwable t) {
                fragment.summarizedArticle = null;
                fragment.dialog.hide();
                fragment.showResult();
                t.printStackTrace();
                System.out.print(t.getMessage());
            }
        });
    }

    public static void uploadSummary(final UploadFragment fragment, String id, String text, String summarization) {
        UploadSummarization_interface request = retrofit.create(UploadSummarization_interface.class);
        PostUpload post = new PostUpload(id, text, summarization);
        Call<UploadResult> call = request.getCall(getBaseAuth(), post);
        call.enqueue(new Callback<UploadResult>() {
            @Override
            public void onResponse(Call<UploadResult> call, Response<UploadResult> response) {
                fragment.uploadResult = response.body();
                fragment.dialog.hide();
                fragment.showResult();
            }

            @Override
            public void onFailure(Call<UploadResult> call, Throwable t) {
                fragment.uploadResult = null;
                fragment.dialog.hide();
                fragment.showResult();
                t.printStackTrace();
                System.out.print(t.getMessage());
            }
        });
    }



}

