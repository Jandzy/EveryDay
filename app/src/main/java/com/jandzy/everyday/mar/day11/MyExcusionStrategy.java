package com.jandzy.everyday.mar.day11;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2017/3/11 0011.
 */

public class MyExcusionStrategy implements ExclusionStrategy {

    FieldAttributes fs;
    Class<?> clazz;

    public MyExcusionStrategy(FieldAttributes f,Class<?> clazz) {
        this.fs = f;
        this.clazz = clazz;
    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {

        return fs.getName().equals(f.getName());
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return this.clazz == clazz;
    }
}
