package com.itcast.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        final Demo d = new Demo();
        Demo2 o = (Demo2)Proxy.newProxyInstance(d.getClass().getClassLoader(), d.getClass().getInterfaces(), new
                InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object obj = null;
                if ("save".equals(method.getName())) {
                    Float money = (Float)args[0];
                    obj = method.invoke(d, money*0.8f);
                }
                return obj;
            }
        });
        o.save(1000f);
    }
}
