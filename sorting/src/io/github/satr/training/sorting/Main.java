package io.github.satr.training.sorting;

import io.github.satr.training.ArrayHelper;
import io.github.satr.training.algorithms.SortAlgorithms;

public class Main {

    public static void main(String[] args) {
        int[] array = ArrayHelper.createArray(1000);
        ArrayHelper.showArray(array);

//==sort
//        SortAlgorithms.bubbleSort(array);
//        SortAlgorithms.bubbleSort2(array);
//        SortAlgorithms.quickSort(array, 0, array.length - 1);
//        SortAlgorithms.mergeSort(array);
//        SortAlgorithms.insertionSort(array);
//        SortAlgorithms.shellSort(array);
//        SortAlgorithms.sortWithTwoStacks(array);
        SortAlgorithms.combSort(array);

        System.out.println("--- Result:");
        ArrayHelper.showArray(array);
        ArrayHelper.checkOrder(array);
//==search
//        SearchAlgorithms.binarySearch(array, array[array.length / 2]);
    }
}
