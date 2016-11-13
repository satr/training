package io.github.satr.training.tests;

import io.github.satr.training.TreeHelper;
import io.github.satr.training.datastructures.BinarySearchTree;
import org.junit.Test;
import org.junit.Assert;

public class BinarySearchTreeTestCases {

    private BinarySearchTree tree;

    @org.junit.Before
    public void setUp() {
        tree = new BinarySearchTree();
    }

    /*
    *   5
    * */
    @Test
    public void insert1Test() throws Exception {
        tree.insert(5);

        Assert.assertEquals("(n/5\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }

    /*
    *    5
    *  2
    * */
    @Test
    public void insert2Test() throws Exception {
        tree.insert(5);
        tree.insert(2);

        Assert.assertEquals("(n/2\\n)(2/5\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }


    /*
    *    5
    *  2   7
    * */
    @Test
    public void insert3Test() throws Exception {
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);

        Assert.assertEquals("(n/2\\n)(2/5\\7)(n/7\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }

    /*
    *     5
    *  2     7
    *      6
    * */
    @Test
    public void insert4Test() throws Exception {
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(6);

        Assert.assertEquals("(n/2\\n)(2/5\\7)(n/6\\n)(6/7\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }

    /*
    *      5
    *   2     7
    * 1         8
    *            9
    *
    * */
    @Test
    public void insertNumbersTest() throws Exception {
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(8);
        tree.insert(1);
        tree.insert(9);

        Assert.assertEquals("(n/1\\n)(1/2\\n)(2/5\\7)(n/7\\8)(n/8\\9)(n/9\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }


    /*
    *   5
    *   ^
    * */
    @Test
    public void removeRootTest() throws Exception {
        tree.insert(5);

        Assert.assertEquals("(n/5\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }

    /*
    *    5
    *  2
    *  ^
    * */
    @Test
    public void remove2Test() throws Exception {
        tree.insert(5);
        tree.insert(2);

        Assert.assertEquals("(n/2\\n)(2/5\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }


    /*
    *    5
    *  2   7
    *      ^
    * */
    @Test
    public void removeRightTest() throws Exception {
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);

        tree.remove(7);

        Assert.assertEquals("(n/2\\n)(2/5\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }

    /*
    *     5
    *  2     7
    *      6 ^
    * */
    @Test
    public void removeNodeWithOnlyLeftLeafTest() throws Exception {
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(6);

        tree.remove(7);

        Assert.assertEquals("(n/2\\n)(2/5\\6)(n/6\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }

    /*
    *     5
    *  2     8
    *      6 ^
    *       7
    * */
    @Test
    public void removeRootWithMinHavingRightTest() throws Exception {
        tree.insert(5);
        tree.insert(2);
        tree.insert(8);
        tree.insert(6);
        tree.insert(7);

        tree.remove(5);

        Assert.assertEquals("(n/2\\n)(2/6\\8)(n/7\\n)(7/8\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }

    /*
    *      5
    *   2     7
    *         ^ 8
    *            9
    *
    * */
    @Test
    public void removeNodeWithOnlyRightTreeTest() throws Exception {
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);

        tree.remove(7);

        Assert.assertEquals("(n/2\\n)(2/5\\8)(n/8\\9)(n/9\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }

    /*
    *     3
    *  1     5
    *     4    7
    *        6 ^ 10
    *           8  11
    *            9
    * */
    @Test
    public void removeNodeWithRightTreeTest() throws Exception {
        tree.insert(3);
        tree.insert(1);
        tree.insert(5);
        tree.insert(4);
        tree.insert(7);
        tree.insert(6);
        tree.insert(10);
        tree.insert(8);
        tree.insert(11);
        tree.insert(9);

        tree.remove(7);

        Assert.assertEquals("(n/1\\n)(1/3\\5)(n/4\\n)(4/5\\8)(n/6\\n)(6/8\\10)(n/9\\n)(9/10\\11)(n/11\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }


    /*
    *              10
    *           8     11
    *         4   9
    *      2  ^ 6
    *    1  3  5 7
    *
    * */
    @Test
    public void removeNodeWithLeftTreeTest() throws Exception {
        tree.insert(10);
        tree.insert(11);
        tree.insert(8);
        tree.insert(9);
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        tree.remove(4);

        Assert.assertEquals("(n/1\\n)(1/2\\3)(n/3\\n)(2/5\\6)(n/6\\7)(n/7\\n)(5/8\\9)(n/9\\n)(8/10\\11)(n/11\\n)", TreeHelper.toTextInOrderTraversal(tree.getRoot()));
        TreeHelper.showTree(tree.getRoot());
    }



}
