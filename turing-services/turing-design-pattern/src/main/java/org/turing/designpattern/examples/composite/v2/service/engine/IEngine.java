package org.turing.designpattern.examples.composite.v2.service.engine;

import org.turing.designpattern.examples.composite.v2.model.aggregates.TreeRich;
import org.turing.designpattern.examples.composite.v2.model.vo.EngineResult;

import java.util.Map;

public interface IEngine {

    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);

}