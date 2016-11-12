package io.github.satr.training.hashtable.tests;

import io.github.satr.training.datastructures.HashTableEx;
import org.junit.Assert;
import org.junit.Test;

public class HashTableTests {

    private HashTableEx<TestObj, Integer> hashtable;
    private Integer value1 = new Integer(1);
    private Integer value2 = new Integer(2);
    private Integer value3 = new Integer(3);
    private Integer value4 = new Integer(4);
    private int hash1 = 1;
    private int hash2 = 2;
    private int hash3 = 3;
    private TestObj obj1Hash1;
    private TestObj obj2Hash2;
    private TestObj obj3Hash3;
    private TestObj obj4Hash1;

    @org.junit.Before
    public void setUp() throws Exception {
        hashtable = new HashTableEx<>();
        obj1Hash1 = new TestObj(hash1);
        obj2Hash2 = new TestObj(hash2);
        obj3Hash3 = new TestObj(hash3);
        obj4Hash1 = new TestObj(hash1);
    }

    @Test
    public void emptyTest() throws Exception {
        Assert.assertTrue(hashtable.isEmpty());
    }

    @Test
    public void notGetFromEmptyTest() throws Exception {
        Assert.assertNull(hashtable.get(obj1Hash1));
    }

    @Test
    public void notGetNotExistingFromNotEmptyTest() throws Exception {
        hashtable.put(obj1Hash1, value1);
        Assert.assertNull(hashtable.get(obj2Hash2));
    }

    @Test
    public void getExistingTest() throws Exception {
        hashtable.put(obj1Hash1, value1);
        Assert.assertEquals(value1, hashtable.get(obj1Hash1));
    }

    @Test
    public void addAndGetTwoValuesTest() throws Exception {
        hashtable.put(obj1Hash1, value1);
        hashtable.put(obj2Hash2, value2);
        Assert.assertEquals(value1, hashtable.get(obj1Hash1));
        Assert.assertEquals(value2, hashtable.get(obj2Hash2));
    }

    @Test
    public void addAndGetTreeValuesTest() throws Exception {
        hashtable.put(obj1Hash1, value1);
        hashtable.put(obj2Hash2, value2);
        hashtable.put(obj3Hash3, value3);

        Assert.assertEquals(value1, hashtable.get(obj1Hash1));
        Assert.assertEquals(value2, hashtable.get(obj2Hash2));
        Assert.assertEquals(value3, hashtable.get(obj3Hash3));
    }

    @Test
    public void addTwoKeysWithSameHashTest() throws Exception {
        hashtable.put(obj1Hash1, value1);
        hashtable.put(obj4Hash1, value2);
        hashtable.put(obj2Hash2, value3);

        Assert.assertEquals(value1, hashtable.get(obj1Hash1));
        Assert.assertEquals(value2, hashtable.get(obj4Hash1));
        Assert.assertEquals(value3, hashtable.get(obj2Hash2));
    }

    @Test
    public void nullKeyTest() throws Exception {
        hashtable.put(null, value1);
        hashtable.put(obj1Hash1, value2);
        Assert.assertEquals(value1, hashtable.get(null));
        Assert.assertEquals(value2, hashtable.get(obj1Hash1));
    }

    @Test
    public void replaceValueTest() throws Exception {
        hashtable.put(obj1Hash1, value1);
        hashtable.put(obj1Hash1, value2);

        Assert.assertEquals(value2, hashtable.get(obj1Hash1));
    }

    @Test
    public void removeExistingTest() throws Exception {
        hashtable.put(obj1Hash1, value1);

        hashtable.remove(obj1Hash1);

        Assert.assertNull(hashtable.get(obj1Hash1));
    }

    @Test
    public void removeOneFromMultipleTest() throws Exception {
        hashtable.put(obj1Hash1, value1);
        hashtable.put(obj2Hash2, value2);
        hashtable.put(obj3Hash3, value3);

        hashtable.remove(obj2Hash2);

        Assert.assertEquals(value1, hashtable.get(obj1Hash1));
        Assert.assertNull(hashtable.get(obj2Hash2));
        Assert.assertEquals(value3, hashtable.get(obj3Hash3));
    }
}