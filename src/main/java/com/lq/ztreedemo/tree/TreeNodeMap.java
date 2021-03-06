package com.lq.ztreedemo.tree;

import java.util.HashMap;
import java.util.List;

public class TreeNodeMap extends HashMap {

    private TreeNodeConfig treeNodeConfig;

    public TreeNodeMap(TreeNodeConfig treeNodeConfig){
        this.treeNodeConfig=treeNodeConfig;
    }

    public <T> T getId() {
        return (T)super.get(treeNodeConfig.getIdKey());
    }

    public void setId(String id) {
        super.put(treeNodeConfig.getIdKey(),id);
    }

    public <T> T getName() {
        return (T)super.get(treeNodeConfig.getNameKey());
    }

    public void setName(String name) {
        super.put(treeNodeConfig.getNameKey(),name);
    }

    public <T> T getCode() {
        return (T)super.get(treeNodeConfig.getCodeKey());
    }

    public void setCode(String code) {
        super.put(treeNodeConfig.getCodeKey(),code);
    }

    public <T> T getParentId() {
        return (T)super.get(treeNodeConfig.getParentIdKey());
    }

    public void setParentId(String parentId) {
        super.put(treeNodeConfig.getParentIdKey(),parentId);
    }

    public List<TreeNodeMap> getChildren() {
        return (List<TreeNodeMap>) super.get(treeNodeConfig.getChildrenKey());
    }

    public void setChildren(List<TreeNodeMap> children) {
        super.put(treeNodeConfig.getChildrenKey(),children);
    }

    public void extra(String key,Object value){
        super.put(key,value);
    }
}
