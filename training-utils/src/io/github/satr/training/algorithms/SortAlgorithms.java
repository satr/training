package io.github.satr.training.algorithms;

import io.github.satr.training.ArrayHelper;

import java.util.Stack;

public class SortAlgorithms {

    //------------------------------------------------------------------------------------
    public static void shellSort(int[] array) {
        int length = array.length;
        for (int k = length / 2; k > 0; k /= 2) {
            for (int i = k; i < length; i++) {
                int tmp = array[i];
                int j = i;
                while (j >= k) {
                    if(tmp < array[j - k]) {
                        array[j] = array[j - k];
                        j = j - k;
                    } else {
                        break;
                    }
                }
                array[j] = tmp;
            }
        }
    }

    //------------------------------------------------------------------------------------
    public static void sortWithTwoStacks(int[] array) {
        Stack<Integer> stack1 = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            stack1.push(array[i]);
        }
        Stack<Integer> stack2 = new Stack<>();

        while(!stack1.isEmpty()) {
            int tmp = stack1.pop();
            while(!stack2.isEmpty() && stack2.peek() < tmp) {
                stack1.push(stack2.pop());
            }
            stack2.push(tmp);
        }
        int i = 0;
        while(!stack2.isEmpty() && i < array.length) {
            array[i++] = stack2.pop();
        }
    }

    //------------------------------------------------------------------------------------
    public static void insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int insVal = array[i];
            int insInd = i;
            while(insInd > 0 && insVal < array[insInd - 1]) {
                array[insInd] = array[insInd - 1];
                insInd--;
            }
            array[insInd] = insVal;
        }
    }

    //------------------------------------------------------------------------------------
    public static void mergeSort(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] helper, int low, int high) {
        if(low >= high)
            return;
        int medium = (low + high) / 2;
        mergeSort(array, helper, low, medium);
        mergeSort(array, helper, medium + 1, high);
        merge(array, helper, low, medium, high);
    }

    private static void merge(int[] array, int[] helper, int low, int medium, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }
        int helperLeft = low;
        int helperRight = medium + 1;
        int current = low;
        while(helperLeft <= medium && helperRight <= high) {
            if(helper[helperLeft] < helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        int remaining = medium - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }

    //------------------------------------------------------------------------------------
    public static void quickSort(int[] array, int left, int right) {
        int index = partition(array, left, right);
        if(left < index - 1)
            quickSort(array, left, index - 1);
        if(right > index)
            quickSort(array, index, right);
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];
        while (left <= right) {
            while (array[left] < pivot)
                left++;
            while (array[right] > pivot)
                right--;
            if(left <= right) {
                ArrayHelper.swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    //------------------------------------------------------------------------------------
    public static void bubbleSort(int[] array) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    ArrayHelper.swap(array, i, i + 1);
                    swapped = true;
                }
            }
        }
    }

    public static void bubbleSort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    ArrayHelper.swap(array, i, j);
                }
            }
        }
    }

    public static void combSort(int[] array) {
        int gap = array.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if(gap > 1)
                gap /= 1.247;
            swapped = false;
            int i = 0;
            while (i + gap < array.length) {
                if(array[i] > array[i + gap]) {
                    ArrayHelper.swap(array, i, i + gap);
                    swapped = true;
                }
                i++;
            }
        }
    }
}
