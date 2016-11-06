package io.github.satr.training.problems;

import io.github.satr.training.LinkedListHelper;
import io.github.satr.training.datastructures.LinkedListEx;
import io.github.satr.training.datastructures.NodeEx;

import java.util.Random;

public class LinkedListProblems {
    public static void reverse() {
        System.out.println("Reverse a linked list.");

        final int bound = 50;
        Random random = new Random(bound);
        LinkedListEx linkedList = LinkedListHelper.createLinkedList(12, random, bound);
        LinkedListHelper.showLinkedList(linkedList);

        linkedList.reverse();
        System.out.println("Reversed:");
        LinkedListHelper.showLinkedList(linkedList);

        linkedList.add(new NodeEx(random.nextInt(bound)));
        linkedList.add(new NodeEx(random.nextInt(bound)));

        System.out.println("Reversed back with two new items:");
        LinkedListHelper.showLinkedList(linkedList);

        linkedList.reverse();

        System.out.println("Reversed again:");
        LinkedListHelper.showLinkedList(linkedList);

    }
}
