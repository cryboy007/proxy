package com.itcast.cglib;


import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) {
        final Demo d = new Demo();
        Demo o = (Demo)Enhancer.create(d.getClass(), new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object obj = null;
                if ("save".equals(method.getName())) {
                    Float money =(Float) objects[0];
                    obj = method.invoke(d,money*0.8f);
                }
                return obj;
            }
        });
        o.save(10000f);
    }
}
