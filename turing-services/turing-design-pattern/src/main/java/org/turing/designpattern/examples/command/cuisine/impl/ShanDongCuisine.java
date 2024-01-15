package org.turing.designpattern.examples.command.cuisine.impl;

import org.turing.designpattern.examples.command.cook.ICook;
import org.turing.designpattern.examples.command.cuisine.ICuisine;

/**
 * @descri: 山东（鲁菜）
 *
 * @author: lj.michale
 * @date: 2024/1/15 16:45
 */
public class ShanDongCuisine implements ICuisine {

    private ICook cook;

    public ShanDongCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}