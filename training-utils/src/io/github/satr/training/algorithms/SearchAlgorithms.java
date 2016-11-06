package io.github.satr.training.algorithms;

public class SearchAlgorithms {
    public static int binarySearch(int[] array, int value) {
        return binarySearch(array, value, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int value, int low, int high) {
        if(low > high)
            return -1;
        int medium = (low + high) / 2;
        if(array[medium] > value)
            return binarySearch(array, value, low, medium - 1);
        if(array[medium] < value)
            return binarySearch(array, value, medium + 1, high);
        return medium;
    }

}
