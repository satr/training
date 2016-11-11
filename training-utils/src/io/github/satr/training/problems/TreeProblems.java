package io.github.satr.training.problems;

import io.github.satr.training.ArrayHelper;
import io.github.satr.training.LinkedListHelper;
import io.github.satr.training.TreeHelper;
import io.github.satr.training.algorithms.SortAlgorithms;
import io.github.satr.training.algorithms.TreeBalancingDayStoutWarren;
import io.github.satr.training.datastructures.BTNodeEx;
import io.github.satr.training.datastructures.LinkedListEx;
import io.github.satr.training.datastructures.NodeEx;

import java.util.ArrayList;

import static io.github.satr.training.TreeHelper.createTree;
import static io.github.satr.training.TreeHelper.showTree;

public class TreeProblems {
    public static void createLinkedListsForEachLevelOfBinaryTreeWithBreadthFirstTraversal() {
        System.out.println("List of linked lists - one for each level of binary tree. Breadth first traversal.");

        BTNodeEx rootNode = createTree(3);
        showTree(rootNode);

        ArrayList<LinkedListEx> levels = new ArrayList<>();
        LinkedListEx rootList = new LinkedListEx();
        rootList.add(new NodeEx(rootNode));
        levels.add(rootList);

        createListsForLevelsV1(rootList, levels);

        System.out.println("Result:");
        int level = 0;
        for (LinkedListEx linkedList: levels) {
            System.out.printf("Level %d:\n", level++);
            LinkedListHelper.showLinkedList(linkedList);
        }
    }

    private static void createListsForLevelsV1(LinkedListEx parentList, ArrayList<LinkedListEx> levels) {
        NodeEx<BTNodeEx> node = parentList.getFirst();
        if(node == null)
            return;
        LinkedListEx levelList = new LinkedListEx();
        while (node != null) {
            BTNodeEx left = node.getData().getLeft();
            if(left != null)
                levelList.add(new NodeEx(left));
            BTNodeEx right = node.getData().getRight();
            if(right != null)
                levelList.add(new NodeEx(right));
            node = node.getNext();
        }
        if(levelList.isEmpty())
            return;
        levels.add(levelList);
        createListsForLevelsV1(levelList, levels);
    }

    public static void createLinkedListsForEachLevelOfBinaryTreeWithPreOrderTraversal() {
        System.out.println("List of linked lists - one for each level of binary tree. Pre-order traversal.");

        BTNodeEx rootNode = createTree(3);
        showTree(rootNode);

        ArrayList<LinkedListEx> levels = new ArrayList<>();
        createListsForLevelsV2(rootNode, levels, 0);

        System.out.println("Result:");
        int level = 0;
        for (LinkedListEx linkedList: levels) {
            System.out.printf("Level %d:\n", level++);
            LinkedListHelper.showLinkedList(linkedList);
        }
    }

    private static void createListsForLevelsV2(BTNodeEx node, ArrayList<LinkedListEx> levels, int level) {
        if(node == null)
            return;

        if (level >= levels.size())
            levels.add(new LinkedListEx());

        levels.get(level).add(new NodeEx(node));

        createListsForLevelsV2(node.getLeft(), levels, level + 1);
        createListsForLevelsV2(node.getRight(), levels, level + 1);
    }

    public static void convertSortedArrayToBalancedBST() {
        System.out.println("Convert Sorted Array To Balanced BST");

        int[] array = ArrayHelper.createArray(25, 30);
        SortAlgorithms.mergeSort(array);
        ArrayHelper.showArray(array);

        BTNodeEx rootNode = convertSortedArrayToBalancedBST(array, 0, array.length - 1);

        TreeHelper.showTree(rootNode);
    }

    private static BTNodeEx convertSortedArrayToBalancedBST(int[] array, int low, int high) {
        if(low > high)
            return null;
        int medium = (low + high) / 2;
        BTNodeEx node = new BTNodeEx(array[medium]);
        node.setLeft(convertSortedArrayToBalancedBST(array, low, medium - 1));
        node.setRight(convertSortedArrayToBalancedBST(array, medium + 1, high));
        return node;
    }

    public static void testDSWTreeBalancing() {
        System.out.println("Test DSW Tree Balancing");

        int levels = 3;
        BTNodeEx root = createTree(levels);
        TreeHelper.showTree(root);
        TreeBalancingDayStoutWarren dswAlgorithm = new TreeBalancingDayStoutWarren(root);
        dswAlgorithm.createVine();
        System.out.println("-------- vine ---------");
        TreeHelper.showTree(dswAlgorithm.getRoot());
        dswAlgorithm.createCompleteBST();
        System.out.println("-------- result ---------");
        TreeHelper.showTree(dswAlgorithm.getRoot());
    }

    public static void checkIfTreeIsBST() {
        System.out.println("\nCheck if tree is BST.\n");

        checkIfTreeIsBST(TreeHelper.createNotBSTTree1());
        checkIfTreeIsBST(TreeHelper.createNotBSTTree2());
        checkIfTreeIsBST(TreeHelper.createBSTTree());//TODO: find out why - should be BST but not recognized as such
        checkIfTreeIsBST(TreeHelper.createLinkedListAsBSTTree());
        checkIfTreeIsBST(TreeHelper.createLinkedListAsNotBSTTree());
    }

    private static void checkIfTreeIsBST(BTNodeEx rootNode) {
        TreeHelper.showTree(rootNode);

        boolean isBST = treeIsBST(rootNode, null, null);

        System.out.println(isBST ? "Is BST" : "Is not BST");
    }

    // -- borrowed code: not sure if works correct
    private static boolean treeIsBST(BTNodeEx node, Integer min, Integer max) {
        if (node == null)
            return true;
        if ((min != null && node.getValue() <= min)
                || (max != null && node.getValue() > max))
            return false;
        if(!treeIsBST(node.getLeft(), min, node.getValue())
                || !treeIsBST(node.getRight(), node.getValue(), max))
            return false;
        return true;
    }

    public static void delete(BTNodeEx node) {
        if(node.leftIsLeaf())
            deleteLeaf(node);
        else if(node.rightIsEmpty() && !node.leftIsEmpty() )
            deleteNodeWithRightOnly(node);
        else if (!node.rightIsEmpty() && node.leftIsEmpty())
            deleteNodeWithLeftOnly(node);
        else
            deleteNodeWithLeftAndRight(node);
        node.setParent(null);
    }

    private static void deleteNodeWithLeftAndRight(BTNodeEx node) {
        BTNodeEx parent = node.getParent();
        BTNodeEx left = node.getLeft();
        BTNodeEx right = node.getRight();
        right.setParent(parent);
        if (parent != null) {
            if(parent.getLeft() == node)
                parent.setLeft(right);
            else
                parent.setRight(right);
        }
        right.setLeft(left);
        left.setParent(right);
        node.setRight(null);
        node.setLeft(null);
    }

    private static void deleteNodeWithLeftOnly(BTNodeEx node) {
        node.getRight().setParent(node.getParent());
        node.setRight(null);
    }

    private static void deleteNodeWithRightOnly(BTNodeEx node) {
        node.getLeft().setParent(node.getParent());
        node.setLeft(null);
    }

    private static void deleteLeaf(BTNodeEx node) {
        BTNodeEx parent = node.getParent();
        if(parent == null)
            return;//the leaf is the only node in the tree
        if(parent.getRight() == node) {
            parent.setRight(null);
        } else if(parent.getLeft() == node) {
            parent.setLeft(null);
        } else {
            reportInvalidRelationship(node, parent);
            return;
        }
    }

    private static void reportInvalidRelationship(BTNodeEx node, BTNodeEx parent) {
        System.err.format("Node %s has parent %s but it is not its left or right assessor.", node, parent);
    }
}
