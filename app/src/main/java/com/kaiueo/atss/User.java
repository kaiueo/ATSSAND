package com.kaiueo.atss;

/**
 * Created by zhangke on 18/02/2018.
 */

public class User {
    public int code;
    public String msg;
    public Content data;
    public static class Content{
        public String username;
        public String created_at;
        public int uploads;
        public String avatar;
        public int use;
        public String biography;
    }

    public void show(){
        System.out.println(code);
        System.out.println(msg);
        System.out.println(data.username);
        System.out.println(data.created_at);
        System.out.println(data.uploads);
        System.out.println(data.avatar);
        System.out.println(data.use);
        System.out.println(data.biography);

    }
}
