package com.lq.ztreedemo.util;

import com.lq.ztreedemo.tree.TreeNodeConfig;
import com.lq.ztreedemo.tree.TreeNodeMap;

import java.util.ArrayList;
import java.util.List;

public class TreeUtil {
    public interface Convert<T>{
        public void convert(T treeObject,TreeNodeMap treeNode);
    }


    public static <T> List<TreeNodeMap> build(List<T> trees, String parentId, TreeNodeConfig treeNodeConfig, Convert convert){
        ArrayList<TreeNodeMap> list = new ArrayList();

        ArrayList<TreeNodeMap> treeNodes = new ArrayList();
        for(T tree:trees){
            TreeNodeMap treeNode = new TreeNodeMap(treeNodeConfig);
            convert.convert(tree,treeNode);
            treeNodes.add(treeNode);
        }

        for(TreeNodeMap treeNode:treeNodes){
            if (treeNode.getParentId().equals(parentId)){
                list.add(treeNode);
                innerBuild(treeNodes,treeNode);
            }
        }
        return list;
    }

    public static void innerBuild(List<TreeNodeMap> treeNodes,TreeNodeMap parentTreeNode){
        for (TreeNodeMap treeNode:treeNodes){
            if (treeNode.getParentId().equals(parentTreeNode.getId())){
                if (parentTreeNode.getChildren()==null){
                    parentTreeNode.setChildren(new ArrayList<TreeNodeMap>());
                }
                parentTreeNode.getChildren().add(treeNode);
                innerBuild(treeNodes,treeNode);
            }
        }
    }
}
