package io.github.satr.training.datastructures;

public class BTNodeEx {
    BTNodeEx[] nodes = new BTNodeEx[2];
    private int leftNodeIndex = 0;
    private int rightNodeIndex = 1;
    private int value;

    public BTNodeEx(int value) {

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setLeft(BTNodeEx node) {
        nodes[leftNodeIndex] = node;
    }

    public void setRight(BTNodeEx node) {
        nodes[rightNodeIndex] = node;
    }

    public BTNodeEx getLeft() {
        return nodes[leftNodeIndex];
    }

    public BTNodeEx getRight() {
        return nodes[rightNodeIndex];
    }

    @Override
    public String toString() {
        return "BTNodeEx{" +
                "value=" + value +
                '}';
    }
}
