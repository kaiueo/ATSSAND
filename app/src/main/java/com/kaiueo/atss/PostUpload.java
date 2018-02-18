package com.kaiueo.atss;

/**
 * Created by zhangke on 18/02/2018.
 */

public class PostUpload {
    public String id;
    public String text;
    public String summarization;
    public PostUpload(String id, String text, String summarization){
        this.id = id;
        this.text = text;
        this.summarization = summarization;
    }
}
