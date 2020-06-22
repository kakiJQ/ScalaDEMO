package com.atguigu.java.chapter01;

import java.lang.reflect.Field;

/**
 * @Description
 * @Author kaki
 * @create 2020-05-19-7:57 AM
 */
public class Test03_String {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s = " a b ";

        Class<? extends String> aClass = s.getClass();
        Field f = aClass.getDeclaredField("value");

        f.setAccessible(true);
        char[] cs = (char[])f.get(s);
        cs[2] = 'd';

        System.out.println(s);

        
    }
}
