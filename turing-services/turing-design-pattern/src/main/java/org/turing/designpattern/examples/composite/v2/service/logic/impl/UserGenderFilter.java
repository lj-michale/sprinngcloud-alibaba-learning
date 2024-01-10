package org.turing.designpattern.examples.composite.v2.service.logic.impl;

import org.turing.designpattern.examples.composite.v2.service.logic.BaseLogic;

import java.util.Map;

public class UserGenderFilter extends BaseLogic {

    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("gender");
    }

}