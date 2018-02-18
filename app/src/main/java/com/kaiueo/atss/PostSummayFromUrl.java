package com.kaiueo.atss;

import retrofit2.http.POST;

/**
 * Created by zhangke on 18/02/2018.
 */

public class PostSummayFromUrl {
    public int type;
    public String url;
    public int count;

    public PostSummayFromUrl(int type, String url, int count){
        this.type = type;
        this.url = url;
        this.count = count;
    }
}
