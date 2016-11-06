package io.github.satr.training.tree;

import io.github.satr.training.problems.TreeProblems;

public class Main {

    public static void main(String[] args) {
        TreeProblems.testDSWTreeBalancing();//TODO - not completed work

        TreeProblems.convertSortedArrayToBalancedBST();

        TreeProblems.createLinkedListsForEachLevelOfBinaryTreeWithBreadthFirstTraversal();

        TreeProblems.createLinkedListsForEachLevelOfBinaryTreeWithPreOrderTraversal();
    }
}
