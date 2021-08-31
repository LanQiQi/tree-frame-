package com.lq.ztreedemo.tree;

import java.util.List;

public class TreeNodeConfig {
//    private static TreeNodeConfig defaultConfig=new TreeNodeConfig();

    static final String TREE_ID = "id";
    static final String TREE_NAME = "name";
    static final String TREE_CODE = "code";
    static final String TREE_PARENT_ID = "parentId";
    static final String TREE_CHILDREN = "children";

    private String idKey;
    private String codeKey;
    private String nameKey;
    private String parentIdKey;
    private String childrenKey;

    public String getIdKey(){
        return getOrDefault(this.idKey,TREE_ID);
    }
    public void setIdkey(String idkey){
        this.idKey=idkey;
    }


    public String getCodeKey() {
        return getOrDefault(this.codeKey,TREE_CODE);
    }

    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }

    public String getNameKey() {
        return getOrDefault(this.nameKey,TREE_NAME);
    }

    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }

    public String getParentIdKey() {
        return getOrDefault(this.parentIdKey,TREE_PARENT_ID);
    }

    public void setParentIdKey(String parentIdKey) {
        this.parentIdKey = parentIdKey;
    }

    public String getChildrenKey() {
        return getOrDefault(this.childrenKey,TREE_CHILDREN);
    }

    public void setChildrenKey(String childrenKey) {
        this.childrenKey = childrenKey;
    }

    public String getOrDefault(String key,String defaultKey){
        if (key==null){
            return defaultKey;
        }
        return key;
    }
}
