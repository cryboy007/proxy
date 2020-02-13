package com.itcast.cglib;

import com.itcast.proxy.Demo2;

public class Demo implements Demo2{
    public void save(Float f) {
        System.out.println("付款了"+f);
    }

    public void destory(Float f) {
        System.out.println("交了"+f);
    }
}
