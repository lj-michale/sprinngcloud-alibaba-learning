package org.turing.designpattern.examples.composite.v2.service.engine;

import org.turing.designpattern.examples.composite.v2.service.logic.LogicFilter;
import org.turing.designpattern.examples.composite.v2.service.logic.impl.UserAgeFilter;
import org.turing.designpattern.examples.composite.v2.service.logic.impl.UserGenderFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @descri: 
 *
 * @author: lj.michale
 * @date: 2024/1/4 17:43
 */
public class EngineConfig {

    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }

    public Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        this.logicFilterMap = logicFilterMap;
    }

}