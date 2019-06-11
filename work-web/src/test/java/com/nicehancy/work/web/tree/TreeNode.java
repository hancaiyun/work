package com.nicehancy.work.web.tree;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 *      节点
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/6/5 14:32
 **/
@Data
@ToString
public class TreeNode {

    /**
     * 构造方法
     * @param value  值
     */
    public TreeNode(int value){
        this.value = value;
    }

    /**
     * 左节点
     */
    private TreeNode leftTreeNode;

    /**
     * 右节点
     */
    private TreeNode rightTreeNode;

    /**
     * 值
     */
    private int value;
}