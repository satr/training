package io.github.satr.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayHelper {

    public static int[] createArray(int dimension) {
        int bound = 0;
        return createArray(dimension, bound);
    }

    public static int[] createArray(int dimension, int bound) {
        List<Integer> uniqueValues = new ArrayList<>();
        uniqueValues.add(0);//do not use 0 as a value
        int[] array = new int[dimension];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = getRandomValue(uniqueValues, random, bound);
        }
        return array;
    }

    private static int getRandomValue(List<Integer> uniqueValues, Random random, int bound) {
        for(;;) {
            int value = bound == 0 ? random.nextInt() : random.nextInt(bound);
            if(!uniqueValues.contains(value))
            {
                uniqueValues.add(value);
                return value;
            }
        }
    }

    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void checkOrder(int[] array) {
        if(array.length == 0)
        {
            System.out.println("Array is empty");
            return;
        }
        for (int i = 1; i < array.length; i++) {
            if(array[i-1] > array[i]){
                System.out.printf("Fail in index %5d\n", i);
                System.out.printf("%10d\n", array[i-1]);
                System.out.printf("%10d\n", array[i]);
                return;
            }
        }
        System.out.println("Ordered Ok");
    }


    public static void showArray(int[] array) {
        if(array.length <= 15) {
            showArray(array, 0, array.length - 1);
            return;
        }
        showArray(array, 0, 5);
        System.out.println("...");
        showArray(array, array.length - 6, array.length - 1);
    }

    private static void showArray(int[] array, int lowIndex, int highIndex) {
        for (int i = lowIndex; i <= highIndex; i++) {
            System.out.printf("%10d:%20d\n", i, array[i]);
        }
    }

    public static void reverse(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (low < high)
            swap(array, low++, high--);
    }
}
