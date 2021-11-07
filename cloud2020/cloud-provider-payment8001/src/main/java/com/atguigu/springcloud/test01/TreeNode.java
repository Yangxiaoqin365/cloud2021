package com.atguigu.springcloud.test01;

import lombok.Data;

import java.util.List;

/**
 * @author yxq
 * @data 2021/10/14 20:47
 */
@Data
public class TreeNode {
    private String id;
    private String parentId;
    private String name;
    private List<TreeNode> children;


    public TreeNode(String id, String name, String parentId) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }
    public TreeNode(String id, String name, TreeNode parent) {
        this.id = id;
        this.parentId = parent.getId();
        this.name = name;
    }

    public List<TreeNode> getChildren() {
        return children;
    }
    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
    @Override
    public String toString() {
        return "TreeNode{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}

