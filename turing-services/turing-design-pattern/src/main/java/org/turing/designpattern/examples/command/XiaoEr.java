package org.turing.designpattern.examples.command;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.turing.designpattern.examples.command.cuisine.ICuisine;

import java.util.ArrayList;
import java.util.List;

/**
 * @descri:  饭店小二，负责点单
 *
 * @author: lj.michale
 * @date: 2024/1/15 16:48
 */
public class XiaoEr {

    private Logger logger = LoggerFactory.getLogger(XiaoEr.class);

    private List<ICuisine> cuisineList = new ArrayList<ICuisine>();

    public void order(ICuisine cuisine) {
        cuisineList.add(cuisine);
    }

    public synchronized void placeOrder() {
        for (ICuisine cuisine : cuisineList) {
            cuisine.cook();
        }
        cuisineList.clear();
    }

}