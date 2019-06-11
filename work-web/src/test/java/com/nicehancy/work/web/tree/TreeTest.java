package com.nicehancy.work.web.tree;

import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * <p>
 *      test
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/6/5 14:04
 **/
@Slf4j
public class TreeTest extends BaseSpringTest {

    /**
     *
     */
    @Test
    public void treeTest(){

        Tree tree = new Tree();
        tree.insert(1,6);
        tree.insert(2,3);
        tree.insert(3,16);
        tree.insert(4,10);
        tree.insert(5,9);
        tree.insert(6,13);
        tree.insert(7,11);
        tree.insert(8,12);
        tree.inOrder(tree.root);
    }

    /**
     * treeNode测试
     */
    @Test
    public void treeNodeTest() {
        //根节点-->10
        TreeNode treeNode1 = new TreeNode(10);

        //左孩子-->9
        TreeNode treeNode2 = new TreeNode(9);

        //右孩子-->20
        TreeNode treeNode3 = new TreeNode(20);

        //20的左孩子-->15
        TreeNode treeNode4 = new TreeNode(15);

        //20的右孩子-->35
        TreeNode treeNode5 = new TreeNode(35);

        //根节点的左右孩子
        treeNode1.setLeftTreeNode(treeNode2);
        treeNode1.setRightTreeNode(treeNode3);



        //20节点的左右孩子
        treeNode3.setLeftTreeNode(treeNode4);
        treeNode3.setRightTreeNode(treeNode5);

        log.info("{}",treeNode1);
        log.info("{}",treeNode2);
        log.info("{}",treeNode3);
        log.info("{}",treeNode4);
        log.info("{}",treeNode5);
    }
}