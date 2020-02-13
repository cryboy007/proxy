package com.itcast.proxy;

public class Demo implements Demo2{
    public void save(Float f) {
        System.out.println("付款了"+f);
    }

    public void destory(Float f) {
        System.out.println("交了"+f);
    }
}
