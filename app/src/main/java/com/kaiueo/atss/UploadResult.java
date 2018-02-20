package com.kaiueo.atss;

import java.util.List;

/**
 * Created by zhangke on 18/02/2018.
 */

public class UploadResult {
    public int code;
    public String msg;
    public List<String> data;

    public void show(){
        System.out.println(code);
        System.out.println(msg);
        System.out.println(data);
    }
}
