package org.turing.designpattern.examples.command.cuisine.impl;

import org.turing.designpattern.examples.command.cook.ICook;
import org.turing.designpattern.examples.command.cuisine.ICuisine;

/**
 * @descri:  四川（川菜）
 *
 * @author: lj.michale
 * @date: 2024/1/15 16:46
 */
public class SiChuanCuisine implements ICuisine {

    private ICook cook;

    public SiChuanCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}