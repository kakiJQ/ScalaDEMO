package com.atguigu.java.chapter01;

import java.io.Serializable;

/**
 * @Description
 * @Author kaki
 * @create 2020-05-19-9:09 AM
 */
public class User05 implements Serializable {
    String name = "aaa";

    public User05() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
