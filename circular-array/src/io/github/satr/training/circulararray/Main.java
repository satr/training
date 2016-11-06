package io.github.satr.training.circulararray;

import io.github.satr.training.datastructures.CircularArrayEx;

public class Main {

    public static void main(String[] args) {
        CircularArrayEx circularArray = new CircularArrayEx<Integer>(5);
        circularArray.set(0, 100);
        System.out.println(circularArray.get(0));
        System.out.println("Run unit-tests.");
    }
}
