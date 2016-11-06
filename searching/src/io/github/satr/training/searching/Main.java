package io.github.satr.training.searching;

import io.github.satr.training.ArrayHelper;
import io.github.satr.training.algorithms.SearchAlgorithms;
import io.github.satr.training.algorithms.SortAlgorithms;

public class Main {

    public static void main(String[] args) {
        int[] array = ArrayHelper.createArray(1000);
        SortAlgorithms.mergeSort(array);
        ArrayHelper.showArray(array);

        int valueToSearch = array[array.length / 2];

        SearchAlgorithms.binarySearch(array, valueToSearch);
    }
}
