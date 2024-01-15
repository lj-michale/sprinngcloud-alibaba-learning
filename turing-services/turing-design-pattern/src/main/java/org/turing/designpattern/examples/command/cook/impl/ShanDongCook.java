package org.turing.designpattern.examples.command.cook.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.turing.designpattern.examples.command.cook.ICook;

public class ShanDongCook implements ICook {

    private Logger logger = LoggerFactory.getLogger(ICook.class);

    public void doCooking() {
        logger.info("山东厨师，烹饪鲁菜，宫廷最大菜系，以孔府风味为龙头");
    }

}