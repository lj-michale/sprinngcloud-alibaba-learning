package org.turing.designpattern.examples.command.cuisine.impl;

import org.turing.designpattern.examples.command.cook.ICook;
import org.turing.designpattern.examples.command.cuisine.ICuisine;


/**
 * @descri: 江苏（苏菜）
 *
 * @author: lj.michale
 * @date: 2024/1/15 16:45
 */
public class JiangSuCuisine implements ICuisine {

    private ICook cook;

    public JiangSuCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}