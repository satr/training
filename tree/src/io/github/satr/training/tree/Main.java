package io.github.satr.training.tree;

import io.github.satr.training.TreeHelper;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Test DSW Tree Balancing");
//        TreeHelper.testDSWTreeBalancing();//TODO - not completed work

//        System.out.println("Convert Sorted Array To Balanced BST");
//        TreeHelper.convertSortedArrayToBalancedBST();

        System.out.println("List of linked lists - one for each level of binary tree.");
        TreeHelper.createLinkedListsForEachLevelOfBinaryTreeWithLevelByLevelTraversal();
//        TreeHelper.createLinkedListsForEachLevelOfBinaryTreeWithPreOrderTraversal();
    }
}
