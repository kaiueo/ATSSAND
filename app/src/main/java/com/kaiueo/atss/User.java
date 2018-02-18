package com.kaiueo.atss;

/**
 * Created by zhangke on 18/02/2018.
 */

public class User {
    private int code;
    private String msg;
    private Content data;
    private static class Content{
        private String username;
        private String created_at;
        private int uploads;
        private String avatar;
        private int use;
    }

    public void show(){
        System.out.println(code);
        System.out.println(msg);
        System.out.println(data.username);
        System.out.println(data.created_at);
        System.out.println(data.uploads);
        System.out.println(data.avatar);
        System.out.println(data.use);

    }
}
