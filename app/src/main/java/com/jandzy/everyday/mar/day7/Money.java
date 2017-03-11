package com.jandzy.everyday.mar.day7;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/8 0008.
 */

public class Money implements Serializable {

    private int count;
    public  String code;
    public String test;
     public String expose;

    public Money() {
    }

    public Money(int count, String code,String expose,String test) {
        this.count = count;
        this.code = code;
        this.expose = expose;
        this.test = test;
    }

    @Override
    public String toString() {
        return this.count+"========"+this.code+"========="+expose;
    }
}
