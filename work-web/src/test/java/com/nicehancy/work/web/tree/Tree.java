package com.nicehancy.work.web.tree;

import lombok.ToString;

/**
 * <p>
 *      树
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/6/5 10:13
 **/
@ToString
public class Tree {

    Node root;//保存树的根

    /**
     * 查找指定节点
     * @param key
     * @return
     */
    public Node find(int key) {
        Node currentNode = root;
        while (currentNode != null && currentNode.key != key) {
            if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }
        }
        return currentNode;
    }

    /**
     * 插入节点
     * @param key
     * @param value
     */
    public void insert(int key, int value) {
        if (root == null) {
            root = new Node(key, value);
            return;
        }
        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftChild = true;
        while (currentNode != null) {
            parentNode = currentNode;
            if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
                isLeftChild = true;
            } else {
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }
        }
        Node newNode = new Node(key, value);
        if (isLeftChild) {
            parentNode.leftChild = newNode;
        } else {
            parentNode.rightChild = newNode;
        }
    }

    /**
     * 删除指定节点
     * 1、待删除的节点是叶子节点，可直接删除
     * 2、待删除的节点只是有一个孩子节点
     * 3、待删除的节点既有左孩子又有右孩子
     * @param key
     * @return
     */
    public boolean delete(int key) {
        return false;
    }

    private Node getDirectPostNode(Node delNode) {
        return null;
    }

    //----------------遍历树--------------------

    /**
     * 先序遍历
     * @param rootNode
     */
    public void preOrder(Node rootNode) {
        if (rootNode != null) {
            System.out.println(rootNode.key + " " + rootNode.value);
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }

    /**
     * 中序遍历
     * @param rootNode
     */
    public void inOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            System.out.println(rootNode.key + " " + rootNode.value);
            inOrder(rootNode.rightChild);
        }
    }

    /**
     * 后序遍历
     * @param rootNode
     */
    public void postOrder(Node rootNode) {
        if (rootNode != null) {
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            System.out.println(rootNode.key + " " + rootNode.value);
        }
    }
}