package io.github.satr.training.searching;

import io.github.satr.training.algorithms.SearchAlgorithms;
import org.junit.Assert;

public class BinarySearchTest {
    @org.junit.Test
    public void foundFirstInOddArrayTest() throws Exception {
        int[] array = {1,2,3};
        int foundIndex = SearchAlgorithms.binarySearch(array, 1);
        Assert.assertEquals(0, foundIndex);
    }

    @org.junit.Test
    public void foundLastInOddArrayTest() throws Exception {
        int[] array = {1,2,3};
        int foundIndex = SearchAlgorithms.binarySearch(array, 3);
        Assert.assertEquals(2, foundIndex);
    }

    @org.junit.Test
    public void foundMiddleTest() throws Exception {
        int[] array = {1,2,3};
        int foundIndex = SearchAlgorithms.binarySearch(array, 2);
        Assert.assertEquals(1, foundIndex);
    }

    @org.junit.Test
    public void foundInFirstPartInOddArrayTest() throws Exception {
        int[] array = {1,2,3,4,5};
        int foundIndex = SearchAlgorithms.binarySearch(array, 2);
        Assert.assertEquals(1, foundIndex);
    }

    @org.junit.Test
    public void foundInLastPartInOddArrayTest() throws Exception {
        int[] array = {1,2,3,4,5};
        int foundIndex = SearchAlgorithms.binarySearch(array, 4);
        Assert.assertEquals(3, foundIndex);
    }

    @org.junit.Test
    public void notFoundInOddArrayTest() throws Exception {
        int[] array = {1,2,3};
        int foundIndex = SearchAlgorithms.binarySearch(array, 9);
        Assert.assertEquals(-1, foundIndex);
    }

   @org.junit.Test
    public void foundFirstInEvenArrayTest() throws Exception {
        int[] array = {1,2,3,4};
        int foundIndex = SearchAlgorithms.binarySearch(array, 1);
        Assert.assertEquals(0, foundIndex);
    }

    @org.junit.Test
    public void foundLastInEvenArrayTest() throws Exception {
        int[] array = {0,1,2,3};
        int foundIndex = SearchAlgorithms.binarySearch(array, 3);
        Assert.assertEquals(3, foundIndex);
    }

    @org.junit.Test
    public void foundInFirstPartInEvenArrayTest() throws Exception {
        int[] array = {1,2,3,4,5};
        int foundIndex = SearchAlgorithms.binarySearch(array, 2);
        Assert.assertEquals(1, foundIndex);
    }

    @org.junit.Test
    public void foundInLastPartInEvenArrayTest() throws Exception {
        int[] array = {1,2,3,4,5,6};
        int foundIndex = SearchAlgorithms.binarySearch(array, 4);
        Assert.assertEquals(3, foundIndex);
    }

    @org.junit.Test
    public void foundAmongRepeatingTest() throws Exception {
        int[] array = {1,2,4,4,5,4,5,6};
        int foundIndex = SearchAlgorithms.binarySearch(array, 4);
        Assert.assertEquals(3, foundIndex);
    }

    @org.junit.Test
    public void notFoundInEvenArrayTest() throws Exception {
        int[] array = {1,2,3,4};
        int foundIndex = SearchAlgorithms.binarySearch(array, 9);
        Assert.assertEquals(-1, foundIndex);
    }

}