package io.github.satr.training.circulararray;

import io.github.satr.training.datastructures.CircularArrayEx;
import org.junit.Assert;
import org.junit.Test;

public class CircularArrayTest {

    private CircularArrayEx circularArray;

    @org.junit.Before
    public void setUp() throws Exception {
        circularArray = new CircularArrayEx(3);
    }

    @Test
    public void SetEntryTest() throws Exception {
        int value = 10;
        int index = 0;
        circularArray.set(index, value);
        Assert.assertEquals(value, circularArray.get(index));
    }

    @Test
    public void setTwoEntriesTest() {
        int index0 = 0;
        int index1 = 1;
        int valueIn0 = 10;
        int valueIn1 = 20;
        circularArray.set(index0, valueIn0);
        circularArray.set(index1, valueIn1);
        Assert.assertEquals(valueIn0, circularArray.get(index0));
        Assert.assertEquals(valueIn1, circularArray.get(index1));
    }

    @Test
    public void setMaxCapacityEntryTest() {
        int index0 = 0;
        int index2 = 2;
        int valueIn0 = 10;
        int valueIn2 = 30;
        circularArray.set(index0, valueIn0);
        circularArray.set(index2, valueIn2);
        Assert.assertEquals(valueIn0, circularArray.get(index0));
        Assert.assertEquals(valueIn2, circularArray.get(index2));
    }

    @Test
    public void setOneOverCapacityEntryTest() {
        int index0 = 0;
        int index1 = 1;
        int index3 = 3;
        int valueIn0 = 10;
        int valueIn1 = 20;
        int valueIn3 = 40;
        circularArray.set(index0, valueIn0);
        circularArray.set(index1, valueIn1);
        circularArray.set(index3, valueIn3);
        Assert.assertEquals(valueIn3, circularArray.get(index0));
        Assert.assertEquals(valueIn3, circularArray.get(index3));
    }

    @Test
    public void setNegativeOneEntryTest() {
        int index0 = 0;
        int index1 = 1;
        int index2 = 2;
        int indexNegative1 = -1;
        int valueIn0 = 10;
        int valueIn1 = 20;
        int valueIn2 = 30;
        int valueInNegative1 = 40;
        circularArray.set(index0, valueIn0);
        circularArray.set(index1, valueIn1);
        circularArray.set(index2, valueIn2);
        circularArray.set(indexNegative1, valueInNegative1);
        Assert.assertEquals(valueIn1, circularArray.get(index1));
        Assert.assertEquals(valueInNegative1, circularArray.get(indexNegative1));
    }

    @Test
    public void setNegativeTwoEntryTest() {
        int index0 = 0;
        int index1 = 1;
        int index2 = 2;
        int indexNegative2 = -2;
        int valueIn0 = 10;
        int valueIn1 = 20;
        int valueIn2 = 30;
        int valueInNegative2 = 40;
        circularArray.set(index0, valueIn0);
        circularArray.set(index1, valueIn1);
        circularArray.set(index2, valueIn2);
        circularArray.set(indexNegative2, valueInNegative2);
        Assert.assertEquals(valueInNegative2, circularArray.get(index1));
        Assert.assertEquals(valueInNegative2, circularArray.get(indexNegative2));
    }

    @Test
    public void setTwoOverCapacityEntryTest() {
        int index0 = 0;
        int index1 = 1;
        int index2 = 2;
        int index4 = 4;
        int valueIn0 = 10;
        int valueIn1 = 20;
        int valueIn2 = 30;
        int valueIn4 = 50;
        circularArray.set(index0, valueIn0);
        circularArray.set(index1, valueIn1);
        circularArray.set(index2, valueIn2);
        circularArray.set(index4, valueIn4);
        Assert.assertEquals(valueIn4, circularArray.get(index1));
        Assert.assertEquals(valueIn4, circularArray.get(index4));
    }



}