package org.turing.designpattern.examples.template;


/**
 * @descri: 番茄炒蛋（EggsWithTomato）实现父类中的抽象方法
 *
 * @author: lj.michale
 * @date: 2024/1/10 10:03
 */
public class EggsWithTomato extends DodishTemplate{

    @Override
    public void preparation() {
        System.out.println("洗并切西红柿，打鸡蛋。");
    }

    @Override
    public void doing() {
        System.out.println("鸡蛋倒入锅里，然后倒入西红柿一起炒。");
    }

    @Override
    public void carriedDishes() {
        System.out.println("将炒好的西红寺鸡蛋装入碟子里，端给客人吃。");
    }

}
