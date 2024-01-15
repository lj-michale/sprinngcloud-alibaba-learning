package org.turing.designpattern.examples.command.cuisine.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.turing.designpattern.examples.command.cook.ICook;
import org.turing.designpattern.examples.command.cuisine.ICuisine;

public class GuangDoneCuisine implements ICuisine {

    private ICook cook;

    public GuangDoneCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}