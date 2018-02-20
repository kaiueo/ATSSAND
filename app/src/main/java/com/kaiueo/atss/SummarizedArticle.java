package com.kaiueo.atss;

import java.util.List;

/**
 * Created by zhangke on 18/02/2018.
 */

public class SummarizedArticle {
    public int code;
    public String msg;
    public Content data;
    public static class Content{
        public String article;
        public List<String> summary;
    }

    public void show(){
        System.out.println(code);
        System.out.println(msg);
        System.out.println(data.article);
        System.out.println(data.summary);

    }
}
