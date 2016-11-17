package io.github.satr.training.tests;

import io.github.satr.training.RandomValueGenerator;
import io.github.satr.training.TreeHelper;
import io.github.satr.training.datastructures.AVLBinarySearchTree;
import org.junit.Assert;
import org.junit.Test;

public class AVLBinarySearchTreeTestCases {

    private AVLBinarySearchTree<Integer> tree;

    @org.junit.Before
    public void setUp() {
        tree = new AVLBinarySearchTree<>();
    }

    /*
    *    1
    *    ^
    * after balancing
    *    1
    * */
    @Test
    public void insertAVLOneTest() throws Exception {
        tree.insert(1);

        Assert.assertEquals("(n/1\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        Assert.assertEquals(0, tree.getRoot().getHeight());
        TreeHelper.showTree(tree.getRoot());
    }

    /*
    *      5
    *   2
    * 1
    * ^
    * after balancing
    *    2
    *  1   5
    * */
    @Test
    public void insertWithRightRotationTest() throws Exception {
        tree.insert(5);
        tree.insert(2);

        tree.insert(1);

        Assert.assertEquals("(n/1\\n)(1/2\\5)(n/5\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }

    /*
    *    2
    * 1     6
    *     4
    *      5
    *      ^
    * after balancing
    *    2
    * 1    5
    *    4   6
    * */
    @Test
    public void insertWithDoubleLeftRightRotationTest() throws Exception {
        tree.insert(2);
        tree.insert(1);
        tree.insert(6);
        tree.insert(4);

        tree.insert(5);

        TreeHelper.showTree(tree.getRoot());
        Assert.assertEquals("(n/1\\n)(1/2\\5)(n/4\\n)(4/5\\6)(n/6\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
    }


    /*
    *    2
    * 1     6
    *         8
    *       7
    *       ^
    * after balancing
    *    2
    * 1    7
    *    6  8
    * */
    @Test
    public void insertWithDoubleRightLeftRotationTest() throws Exception {
        tree.insert(2);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);

        tree.insert(7);

        Assert.assertEquals("(n/1\\n)(1/2\\7)(n/6\\n)(6/7\\8)(n/8\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }

    /*
    * 1
    *   2
    *     5
    *     ^
    * after balancing
    *    2
    *  1   5
    * */
    @Test
    public void insertWithLeftRotationTest() throws Exception {
        tree.insert(1);
        tree.insert(2);

        tree.insert(5);

        Assert.assertEquals("(n/1\\n)(1/2\\5)(n/5\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }

    @Test
    public void exampleOfRandomlyGeneratedAVLTreeTest() throws Exception {
        RandomValueGenerator valueGenerator = new RandomValueGenerator(4);
        for (int i = 0; i < valueGenerator.getRange() / 2; i++)
            tree.insert(valueGenerator.getNextValue());

        TreeHelper.showTree(tree.getRoot());
    }


}