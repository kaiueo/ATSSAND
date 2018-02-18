package com.kaiueo.atss;

/**
 * Created by zhangke on 18/02/2018.
 */

public class UnsummarizedArticle {

    private int code;
    private String msg;
    private Content data;
    private static class Content{
        private String id;
        private String text;

    }

    public void show(){
        System.out.println(code);
        System.out.println(msg);
        System.out.println(data.id);
        System.out.println(data.text);
    }
}
