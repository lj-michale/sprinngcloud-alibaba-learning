package org.turing.designpattern.examples.composite.v2.model.aggregates;

import org.turing.designpattern.examples.composite.v2.model.vo.TreeNode;
import org.turing.designpattern.examples.composite.v2.model.vo.TreeRoot;

import java.util.Map;

/**
 * @descri: 规则树聚合
 *
 * @author: lj.michale
 * @date: 2024/1/4 17:38
 */
public class TreeRich {

    private TreeRoot treeRoot;                          //树根信息
    private Map<Long, TreeNode> treeNodeMap;        //树节点ID -> 子节点

    public TreeRich(TreeRoot treeRoot, Map<Long, TreeNode> treeNodeMap) {
        this.treeRoot = treeRoot;
        this.treeNodeMap = treeNodeMap;
    }

    public TreeRoot getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeRoot treeRoot) {
        this.treeRoot = treeRoot;
    }

    public Map<Long, TreeNode> getTreeNodeMap() {
        return treeNodeMap;
    }

    public void setTreeNodeMap(Map<Long, TreeNode> treeNodeMap) {
        this.treeNodeMap = treeNodeMap;
    }
}