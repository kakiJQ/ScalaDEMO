package com.atguigu.java.chapter01;

import java.lang.reflect.Field;

/**
 * @Description
 * @Author kaki
 * @create 2020-05-21-8:40 PM
 */
public class Test06_String {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s = " 2 3 " ;
        String s1 = s  ; //将改变内容前的地址赋值给s1
        System.out.println("改变s的内容前，s1的内容" + s1);

        Class<? extends String> sClass =  s.getClass();

        //获取属性
        Field value = sClass.getDeclaredField("value");
        //获取属性值
        value.setAccessible(true);
        char [] v = (char [] )value.get(s);

        v[2] = 'b';

        System.out.println("!" + s + "!"); // ! 2b3 ! ，说明值发生了改变
        System.out.println("改变s的内容后，s1的内容" + s1);

        //判断改变前后，字符串变量指向的地址值是否有变化
        System.out.println(s == s1); //true，说明地址没有变化

    }
}
