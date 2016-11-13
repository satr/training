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
    public void removeRootWithLeftAndRightTest() throws Exception {
        n2().setRight(n3());
        n2().setLeft(n1());

        TreeProblems.remove(n2());

        String treeAsText = TreeHelper.toTextInOrderTraversal(n3());
        Assert.assertEquals("(n/1\\n)(1/3\\n)", treeAsText);
    }
    /*
    *    2
    *  1   3
    *  ^
    */
    @Test
    public void removeLeftLeafTest() throws Exception {
        n2().setRight(n3());
        n2().setLeft(n1());

        TreeProblems.remove(n1());

        String treeAsText = TreeHelper.toTextInOrderTraversal(n2());
        Assert.assertEquals("(n/2\\3)(n/3\\n)", treeAsText);
    }

    /*
    *    2
    *  1   3
    *      ^
    */
    @Test
    public void removeRightLeafTest() throws Exception {
        n2().setRight(n3());
        n2().setLeft(n1());

        TreeProblems.remove(n3());

        String treeAsText = TreeHelper.toTextInOrderTraversal(n2());
        Assert.assertEquals("(n/1\\n)(1/2\\n)", treeAsText);
        TreeHelper.showTree(n2());
    }

    /*
    *    2
    *  1 ^
    */
    @Test
    public void removeCurrentWithLeftOnlyTest() throws Exception {
        n2().setLeft(n1());

        TreeProblems.remove(n2());

        String treeAsText = TreeHelper.toTextInOrderTraversal(n1());
        Assert.assertEquals("(n/1\\n)", treeAsText);
        TreeHelper.showTree(n1());
    }

    /*
    *  2
    *  ^ 3
    */
    @Test
    public void removeCurrentWithRightOnlyTest() throws Exception {
        n2().setRight(n3());

        TreeProblems.remove(n2());

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
    public void removeCurrentWithLeftAndRightOnlyTest() throws Exception {
        n6().setLeft(n4());
        n4().setLeft(n2());
        n4().setRight(n5());

        TreeProblems.remove(n4());

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
    public void removeCurrentWithSubTreeTest() throws Exception {
        n6().setLeft(n4());
        n4().setLeft(n2());
        n4().setRight(n5());

        TreeProblems.remove(n6());

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
    public void removeCurrentWithSubTreeOnAnotherSideOfRootTest() throws Exception {
        n6().setRight(n7());
        n6().setLeft(n4());
        n4().setLeft(n2());
        n4().setRight(n5());

        TreeProblems.remove(n6());

        String treeAsText = TreeHelper.toTextInOrderTraversal(n7());
        Assert.assertEquals("(n/2\\n)(2/4\\5)(n/5\\n)(4/7\\n)", treeAsText);
        TreeHelper.showTree(n7());
    }
}