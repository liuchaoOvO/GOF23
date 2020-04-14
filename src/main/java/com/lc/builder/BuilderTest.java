package com.lc.builder;

/**
 * @author liuchaoOvO on 2020/4/14
 * @Description TODO
 */
public class BuilderTest {
    public static void main(String[] args) {
        MyEntity myEntity = new MyEntity.Builder().id(123).name("hello builder").build();
        System.out.println("myEntity:" + myEntity);
    }
}
