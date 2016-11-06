package io.github.satr.training.problems;

import io.github.satr.training.ArrayHelper;
import io.github.satr.training.algorithms.SortAlgorithms;

public class SortingProblems {
    public static void bubbleSort() {
        System.out.println("--- Bubble sort.");
        int[] array = getAndShowArray();

        SortAlgorithms.bubbleSort(array);

        showAndCheckResult(array);
    }

    public static void bubbleSort2() {
        System.out.println("--- Bubble sort v2.");
        int[] array = getAndShowArray();

        SortAlgorithms.bubbleSort2(array);

        showAndCheckResult(array);
    }

    public static void quickSort() {
        int[] array = getAndShowArray();

        SortAlgorithms.quickSort(array, 0, array.length - 1);

        showAndCheckResult(array);
    }
    public static void mergeSort() {
        System.out.println("--- Merge sort.");
        int[] array = getAndShowArray();

        SortAlgorithms.mergeSort(array);

        showAndCheckResult(array);
    }

    public static void insertionSort() {
        System.out.println("Insertion sort.");
        int[] array = getAndShowArray();

        SortAlgorithms.insertionSort(array);

        showAndCheckResult(array);
    }
    public static void shellSort() {
        System.out.println("--- Shell sort.");
        int[] array = getAndShowArray();

        SortAlgorithms.shellSort(array);

        showAndCheckResult(array);
    }

    public static void sortWithTwoStacks() {
        System.out.println("--- Sort with two stacks.");
        int[] array = getAndShowArray();

        SortAlgorithms.sortWithTwoStacks(array);

        showAndCheckResult(array);
    }

    public static void combSort() {
        System.out.println("--- Comb sort.");
        int[] array = getAndShowArray();

        SortAlgorithms.combSort(array);

        showAndCheckResult(array);
    }

    private static int[] getAndShowArray() {
        int[] array = ArrayHelper.createArray(1000);
        ArrayHelper.showArray(array);
        return array;
    }

    private static void showAndCheckResult(int[] array) {
        System.out.println(" -- Result:");
        ArrayHelper.showArray(array);
        ArrayHelper.checkOrder(array);
    }
}
