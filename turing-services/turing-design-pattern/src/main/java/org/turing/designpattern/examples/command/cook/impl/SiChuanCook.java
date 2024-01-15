package org.turing.designpattern.examples.command.cook.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.turing.designpattern.examples.command.cook.ICook;

public class SiChuanCook implements ICook {

    private Logger logger = LoggerFactory.getLogger(ICook.class);

    public void doCooking() {
        logger.info("四川厨师，烹饪川菜，中国最有特色的菜系，也是民间最大菜系。");
    }

}