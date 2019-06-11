package com.nicehancy.work.web.tree;

/**
 * <p>
 *     节点
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/6/5 10:15
 **/
public class Node {

    int key;
    int value;
    Node leftChild;
    Node rightChild;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public void displayNode() {

    }
}