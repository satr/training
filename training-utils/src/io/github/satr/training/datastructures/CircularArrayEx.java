package io.github.satr.training.datastructures;

public class CircularArrayEx<T> {
    private final int capacity;
    T[] items;
    private int tail = 0;
    private int head = 0;

    public CircularArrayEx(int capacity) {
        this.items = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public void set(int index, T value) {
        items[getIndex(index)] = value;
    }

    public T get(int index) {
        return items[getIndex(index)];
    }

    private int getIndex(int index) {
        return index < 0 ? capacity + (index % capacity) : index % capacity;
    }
}
