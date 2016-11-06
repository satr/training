package io.github.satr.training;

import io.github.satr.training.datastructures.LinkedListEx;
import io.github.satr.training.datastructures.NodeEx;

import java.util.Random;

public class LinkedListHelper {
    public static LinkedListEx createLinkedList(int length, int bound) {
        Random random = new Random();
        return createLinkedList(length, random, bound);
    }

    public static LinkedListEx createLinkedList(int length, Random random, int bound) {
        LinkedListEx linkedList = new LinkedListEx();
        for (int i = 0; i < length; i++) {
            NodeEx node = new NodeEx();
            node.setData(random.nextInt(bound));
            linkedList.add(node);
        }
        return linkedList;
    }

    public static void showLinkedList(LinkedListEx linkedList) {
        if(linkedList == null) {
            System.out.println("LinkedList is null.");
            return;
        }
        if(linkedList.isEmpty()) {
            System.out.println("LinkedList is empty.");
            return;
        }
        NodeEx node = linkedList.getFirst();
        while(node != null) {
            System.out.printf("(%s)", node.getData());
            node = node.getNext();
        }
        System.out.println();
    }


}
