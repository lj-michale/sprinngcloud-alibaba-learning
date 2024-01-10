package org.turing.designpattern.examples.template;

/**
 * @descri:  抽象的做菜父类
 *
 * @author: lj.michale
 * @date: 2024/1/10 10:03
 */
public abstract class DodishTemplate {
    /**
     * 具体的整个过程
     */
    public void dodish(){
        this.preparation();
        this.doing();
        this.carriedDishes();
    }
    /**
     * 备料
     */
    public abstract void preparation();
    /**
     * 做菜
     */
    public abstract void doing();
    /**
     * 上菜
     */
    public abstract void carriedDishes ();
}