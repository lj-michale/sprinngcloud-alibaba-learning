package org.turing.designpattern.examples.proxy.demo3;


/**
 * @descri:  代理类
 *          在所有的实现类调用wakeup()前增加一行输出早安，调用sleep()前增加一行输出晚安。那我们只需要编写1个代理类PersonProxy
 *
 * @author: lj.michale
 * @date: 2024/1/10 9:37
 */
public class PersonProxy implements Person{
    private Person person;

    public PersonProxy(Person person){
        this.person = person;
    }
    @Override
    public void wakeup() {
        System.out.println("早上好啊!!!");
        person.wakeup();
    }

    @Override
    public void sleep() {
        System.out.println("晚上好啊!!!");
        person.sleep();
    }
}
