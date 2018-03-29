package com.kaiueo.atss;

/**
 * Created by zhangke on 18/02/2018.
 */

public class UnsummarizedArticle {

    public int code;
    public String msg;
    public Content data;
    public static class Content{
        public String id;
        public String text;

    }

    public void show(){
        System.out.println(code);
        System.out.println(msg);
        System.out.println(data.id);
        System.out.println(data.text);
    }
}
