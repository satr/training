package io.github.satr.training.tests;

import io.github.satr.training.TreeHelper;
import io.github.satr.training.datastructures.AVLBinarySearchTree;
import org.junit.Assert;
import org.junit.Test;

public class AVLBinarySearchTreeTestCases {

    private AVLBinarySearchTree tree;

    @org.junit.Before
    public void setUp() throws Exception {
        tree = new AVLBinarySearchTree();
    }

    @Test
    public void insertOneTest() throws Exception {
        tree.insert(1);
        Assert.assertEquals("(n/1\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }
}