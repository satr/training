package io.github.satr.training.hashtable.tests;

public class TestObj implements Comparable<TestObj> {
    private int hash;

    public TestObj(int hash) {

        this.hash = hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        TestObj testObj = (TestObj) o;

        return hash == testObj.hash;

    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public String toString() {
        return "TestObj{" +
                "hash=" + hash +
                '}';
    }

    @Override
    public int compareTo(TestObj o) {
        return o == null || hashCode() < o.hashCode()
                ? -1
                : (hashCode() > o.hashCode() ? 1 : 0);
    }
}
