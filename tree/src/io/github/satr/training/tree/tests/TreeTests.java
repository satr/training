package io.github.satr.training.tree.tests;

import io.github.satr.training.TreeHelper;
import io.github.satr.training.problems.TreeProblems;
import io.github.satr.training.tests.TreeTestBase;
import org.junit.Assert;
import org.junit.Test;

public class TreeTests extends TreeTestBase {
    /*
    *    2
    *  1 ^ 3
    */
    @Test
    public void deleteRootWithLeftAndRightTest() throws Exception {
        n2().setRight(n3());
        n2().setLeft(n1());

        TreeProblems.delete(n2());

        String treeAsText = TreeHelper.toTextInOrderTraversal(n3());
        Assert.assertEquals("(n/1\\n)(1/3\\n)", treeAsText);
    }
    /*
    *    2
    *  1   3
    *  ^
    */
    @Test
    public void deleteLeftLeafTest() throws Exception {
        n2().setRight(n3());
        n2().setLeft(n1());

        TreeProblems.delete(n1());

        String treeAsText = TreeHelper.toTextInOrderTraversal(n2());
        Assert.assertEquals("(n/2\\3)(n/3\\n)", treeAsText);
    }

    /*
    *    2
    *  1   3
    *      ^
    */
    @Test
    public void deleteRightLeafTest() throws Exception {
        n2().setRight(n3());
        n2().setLeft(n1());

        TreeProblems.delete(n3());

        String treeAsText = TreeHelper.toTextInOrderTraversal(n2());
        Assert.assertEquals("(n/1\\n)(1/2\\n)", treeAsText);
        TreeHelper.showTree(n2());
    }

    /*
    *    2
    *  1 ^
    *
    */
    @Test
    public void deleteCurrentWithLeftOnlyTest() throws Exception {
        n2().setLeft(n1());

        TreeProblems.delete(n2());

        String treeAsText = TreeHelper.toTextInOrderTraversal(n1());
        Assert.assertEquals("(n/1\\n)", treeAsText);
        TreeHelper.showTree(n1());
    }

    /*
    *  2
    *  ^ 3
    */
    @Test
    public void deleteCurrentWithRightOnlyTest() throws Exception {
        n2().setRight(n3());

        TreeProblems.delete(n2());

        String treeAsText = TreeHelper.toTextInOrderTraversal(n3());
        Assert.assertEquals("(n/3\\n)", treeAsText);
        TreeHelper.showTree(n3());
    }

    /*
    *      6
    *    4
    *  2 ^ 5
    */
    @Test
    public void deleteCurrentWithLeftAndRightOnlyTest() throws Exception {
        n6().setLeft(n4());
        n4().setLeft(n2());
        n4().setRight(n5());

        TreeProblems.delete(n4());

        String treeAsText = TreeHelper.toTextInOrderTraversal(n6());
        Assert.assertEquals("(n/2\\n)(2/5\\n)(5/6\\n)", treeAsText);
        TreeHelper.showTree(n6());
    }

    /*
    *      6
    *    4 ^
    *  2   5
    */
    @Test
    public void deleteCurrentWithSubTreeTest() throws Exception {
        n6().setLeft(n4());
        n4().setLeft(n2());
        n4().setRight(n5());

        TreeProblems.delete(n6());

        String treeAsText = TreeHelper.toTextInOrderTraversal(n4());
        Assert.assertEquals("(n/2\\n)(2/4\\5)(n/5\\n)", treeAsText);
        TreeHelper.showTree(n4());
    }

    /*
    *       6
    *    4    7
    *  2  5   ^
    */
    @Test
    public void deleteCurrentWithSubTreeOnAnotherSideOfRootTest() throws Exception {
        n6().setRight(n7());
        n6().setLeft(n4());
        n4().setLeft(n2());
        n4().setRight(n5());

        TreeProblems.delete(n6());

        String treeAsText = TreeHelper.toTextInOrderTraversal(n7());
        Assert.assertEquals("(n/2\\n)(2/4\\5)(n/5\\n)(4/7\\n)", treeAsText);
        TreeHelper.showTree(n7());
    }
}