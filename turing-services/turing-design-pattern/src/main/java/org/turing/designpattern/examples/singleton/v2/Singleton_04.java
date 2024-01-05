package org.turing.designpattern.examples.singleton.v2;


/**
 * @descri:   使用类的内部类(线程安全)
 *
 * @author: lj.michale
 * @date: 2024/1/5 10:51
 */
public class Singleton_04 {

    private static class SingletonHolder {
        private static Singleton_04 instance = new Singleton_04();
    }

    private Singleton_04() {
    }

    public static Singleton_04 getInstance() {
        return SingletonHolder.instance;
    }
}