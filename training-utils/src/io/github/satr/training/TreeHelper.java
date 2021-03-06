package io.github.satr.training;


import io.github.satr.training.datastructures.BTNodeEx;

import java.util.ArrayList;
import java.util.List;

public class TreeHelper {

    public static void showTree(BTNodeEx root) {
        System.out.printf("Tree from the root %s\n", root);
        List<BTNodeEx[]> nodeLists = new ArrayList<>();
        nodeLists.add(new BTNodeEx[]{root});
        populateNodeLists(nodeLists);
        for (int i = 0; i < nodeLists.size(); i++) {
            BTNodeEx[] nodeList = nodeLists.get(i);
            showTree(nodeList, nodeLists.size() - i);
        }
    }

    private static void populateNodeLists(List<BTNodeEx[]> nodes) {
        if(nodes.size() == 0)
            return;
        BTNodeEx[] prevNodeLevel = nodes.get(nodes.size() - 1);
        BTNodeEx[] nextNodeLevel = new BTNodeEx[prevNodeLevel.length * 2];
        for (int i = 0; i < prevNodeLevel.length; i++) {
            BTNodeEx node = prevNodeLevel[i];
            nextNodeLevel[i * 2] = (node != null)? node.getLeft(): null;
            nextNodeLevel[i * 2 + 1] = (node != null)? node.getRight(): null;
            nextNodeLevel[i * 2] = (node != null)? node.getLeft(): null;
            nextNodeLevel[i * 2 + 1] = (node != null)? node.getRight(): null;
        }
        boolean existsNotNull = false;
        for (int i = 0; i < nextNodeLevel.length; i++) {
            if(nextNodeLevel[i] != null) {
                existsNotNull = true;
                break;
            }
        }
        if(!existsNotNull)
            return;
        nodes.add(nextNodeLevel);
        populateNodeLists(nodes);
    }

    private static void showTree(BTNodeEx[] nodeList, int levels) {
        showNodeLinks(nodeList, levels);
        showNodeValues(nodeList, levels);
    }

    private static void showNodeValues(BTNodeEx[] nodeList, int levels) {
        if(levels > 0)
            for (int i = 0; i < Math.pow(2, levels - 1) - 1; i++)
                System.out.print("     ");
        for (BTNodeEx node: nodeList) {
            if(node != null)
                System.out.printf("(%3d)", node.getKey());
            else
                System.out.printf("     ");
            for (int i = 0; i < Math.pow(2, levels) - 1; i++) {
                System.out.print("     ");
            }
        }
        System.out.println();
    }
    /*
             012345
    123456789111111. 012345
    1234567.123456789111111.
    123.1234567.1234567.1234567.
    1.123.123.123.123.123.123.123.
    .1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.
    */
    private static void showNodeLinks(BTNodeEx[] nodeList, int levels) {
        if(nodeList.length <= 1)
            return;
        boolean isRight = false;
        if(levels > 0)
            for (int i = 0; i < Math.pow(2, levels - 1) - 1; i++)
                System.out.print("     ");
        for (BTNodeEx node: nodeList) {

            if(!isRight)
                System.out.print(node != null ? "   / " : "     ");
            if(isRight)
                System.out.print(node != null ? " \\   " : "     ");
            isRight = !isRight;
            for (int i = 0; i < Math.pow(2, levels) - 1; i++) {
                System.out.print("     ");
            }
        }
        System.out.println();
    }

    public static BTNodeEx createTree(int levels) {
        RandomValueGenerator valueGenerator = new RandomValueGenerator(levels);
        BTNodeEx root = new BTNodeEx(valueGenerator.getNextValue());
        populateChildNodes(root, levels, valueGenerator);
        return root;
    }

    private static void populateChildNodes(BTNodeEx node, int levels, RandomValueGenerator valueGenerator) {
        if(levels <= 1)
            return;
        BTNodeEx left = new BTNodeEx(valueGenerator.getNextValue());
        node.setLeft(left);
        BTNodeEx right = new BTNodeEx(valueGenerator.getNextValue());
        node.setRight(right);
        populateChildNodes(left, levels - 1, valueGenerator);
        populateChildNodes(right, levels - 1, valueGenerator);
    }

    /*
    *        5
    *     1    4
    *    2 3
    * */
    public static BTNodeEx createNotBSTTree1() {
        BTNodeEx n1 = new BTNodeEx(1);
        BTNodeEx n2 = new BTNodeEx(2);
        BTNodeEx n3 = new BTNodeEx(3);
        BTNodeEx n4 = new BTNodeEx(4);
        BTNodeEx n5 = new BTNodeEx(5);
        n5.setLeft(n1);
        n5.setRight(n4);
        n1.setLeft(n2);
        n1.setRight(n3);
        return n5;
    }

    /*
    *        4
    *     2    5
    *    1 10
    * */
    public static BTNodeEx createNotBSTTree2() {
        BTNodeEx n1 = new BTNodeEx(1);
        BTNodeEx n2 = new BTNodeEx(2);
        BTNodeEx n10 = new BTNodeEx(10);
        BTNodeEx n4 = new BTNodeEx(4);
        BTNodeEx n5 = new BTNodeEx(5);
        n4.setLeft(n2);
        n4.setRight(n5);
        n2.setLeft(n1);
        n2.setRight(n10);
        return n4;
    }

    /*
    *        6
    *     2    7
    *   1  4
    *     3 5
    * */
    public static BTNodeEx createBSTTree() {
        BTNodeEx n1 = new BTNodeEx(1);
        BTNodeEx n2 = new BTNodeEx(2);
        BTNodeEx n3 = new BTNodeEx(3);
        BTNodeEx n4 = new BTNodeEx(4);
        BTNodeEx n5 = new BTNodeEx(5);
        BTNodeEx n6 = new BTNodeEx(6);
        BTNodeEx n7 = new BTNodeEx(7);
        n6.setLeft(n2);
        n6.setRight(n7);
        n2.setLeft(n1);
        n2.setRight(n4);
        n4.setLeft(n3);
        n4.setRight(n5);
        return n6;
    }

    /*
    *         5
    *       4
    *     3
    *   2
    * 1
    * */
    public static BTNodeEx createLinkedListAsBSTTree() {
        BTNodeEx n1 = new BTNodeEx(1);
        BTNodeEx n2 = new BTNodeEx(2);
        BTNodeEx n3 = new BTNodeEx(3);
        BTNodeEx n4 = new BTNodeEx(4);
        BTNodeEx n5 = new BTNodeEx(5);
        n5.setLeft(n4);
        n4.setLeft(n3);
        n3.setLeft(n2);
        n2.setLeft(n1);
        return n5;
    }

    /*
    * 5
    *   4
    *     3
    *       2
    *         1
    * */
    public static BTNodeEx createLinkedListAsNotBSTTree() {
        BTNodeEx n1 = new BTNodeEx(1);
        BTNodeEx n2 = new BTNodeEx(2);
        BTNodeEx n3 = new BTNodeEx(3);
        BTNodeEx n4 = new BTNodeEx(4);
        BTNodeEx n5 = new BTNodeEx(5);
        n5.setRight(n4);
        n4.setRight(n3);
        n3.setRight(n2);
        n2.setRight(n1);
        return n5;
    }

    public static String toTextInOrderTraversal(BTNodeEx node) {
        StringBuilder sb = new StringBuilder();
        addAsText(sb, node);
        return sb.toString();
    }

    private static void addAsText(StringBuilder sb, BTNodeEx node) {
        if(node == null)
            return;
        addAsText(sb, node.getLeft());
        sb.append(node.toText());
        addAsText(sb, node.getRight());
    }
}
