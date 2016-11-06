package io.github.satr.training.compress.tests;

import io.github.satr.training.compress.StringCompressor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCompressorTest {

    private StringCompressor stringCompressor;

    @Before
    public void setUp() throws Exception {
        stringCompressor = new StringCompressor();
    }

    @Test
    public void compress() throws Exception {
        String text = "text";
        Assert.assertEquals(text, stringCompressor.compress(text));
    }

    @Test
    public void nullInputTest() throws Exception {
        Assert.assertNull(stringCompressor.compress(null));
    }

    @Test
    public void emptyTest() throws Exception {
        Assert.assertEquals("", stringCompressor.compress(""));
    }

    @Test
    public void oneCharTest() throws Exception {
        Assert.assertEquals("a", stringCompressor.compress("a"));
    }

    @Test
    public void sameStringWhenNoRepeatedTest() throws Exception {
        Assert.assertEquals("abc", stringCompressor.compress("abc"));
    }

    @Test
    public void sameStringWhenCompressedLongerTest() throws Exception {
        Assert.assertEquals("aab", stringCompressor.compress("aab"));
    }

    @Test
    public void compressedForTreeCharsTest() throws Exception {
        Assert.assertEquals("a3", stringCompressor.compress("aaa"));
    }

    @Test
    public void compressedForTwoDifCharsCharsTest() throws Exception {
        Assert.assertEquals("a3b2", stringCompressor.compress("aaabb"));
    }
}