package org.turing.designpattern.examples.proxy.dynamics.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @descri: 创建一个JdkProxy类，用于统一代理：
 *
 * @author: lj.michale
 * @date: 2024/1/10 9:44
 */
public class JdkProxy implements InvocationHandler {

    private Object bean;

    public JdkProxy(Object bean) {
        this.bean = bean;
    }

    /**
     * 其中proxy为代理过之后的对象(并不是原对象)，method为被代理的方法，args为方法的参数。
     *
     * 如果你不传原有的bean，直接用method.invoke(proxy, args)的话，那么就会陷入一个死循环。
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();

        if (methodName.equals("wakeup")) {
            System.out.println("早安~~~");
        } else if (methodName.equals("sleep")) {
            System.out.println("晚安~~~");
        }

        return method.invoke(bean, args);
    }
}
