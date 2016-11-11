package io.github.satr.training.tree.tests;

import io.github.satr.training.TreeHelper;
import io.github.satr.training.datastructures.BTNodeEx;
import io.github.satr.training.problems.TreeProblems;
import org.junit.Assert;
import org.junit.Test;

public class TreeTests {
    private BTNodeEx n1,n2,n3,n4,n5,n6,n7,n8,n9;

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


    //------------

    public BTNodeEx n1() {
        return n1 != null ? n1 : (n1 = new BTNodeEx(1));
    }

    public BTNodeEx n2() {
        return n2 != null ? n2 : (n2 = new BTNodeEx(2));
    }

    public BTNodeEx n3() {
        return n3 != null ? n3 : (n3 = new BTNodeEx(3));
    }

    public BTNodeEx n4() {
        return n4 != null ? n4 : (n4 = new BTNodeEx(4));
    }

    public BTNodeEx n5() {
        return n5 != null ? n5 : (n5 = new BTNodeEx(5));
    }

    public BTNodeEx n6() {
        return n6 != null ? n6 : (n6 = new BTNodeEx(6));
    }

    public BTNodeEx n7() {
        return n7 != null ? n7 : (n7 = new BTNodeEx(7));
    }

    public BTNodeEx n8() {
        return n8 != null ? n8 : (n8 = new BTNodeEx(8));
    }

    public BTNodeEx n9() {
        return n9 != null ? n9 : (n9 = new BTNodeEx(9));
    }

}