package com.kaiueo.atss;

import java.util.List;

/**
 * Created by zhangke on 18/02/2018.
 */

public class SummarizedArticle {
    private int code;
    private String msg;
    private Content data;
    private static class Content{
        private String article;
        private List<String> summary;
    }

    public void show(){
        System.out.println(code);
        System.out.println(msg);
        System.out.println(data.article);
        System.out.println(data.summary);

    }
}
