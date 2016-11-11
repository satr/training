package io.github.satr.training.datastructures;

public class BTNodeEx {
    BTNodeEx[] nodes = new BTNodeEx[2];
    private int leftNodeIndex = 0;
    private int rightNodeIndex = 1;
    private int value;
    private BTNodeEx parent;

    public BTNodeEx(int value) {

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setLeft(BTNodeEx node) {
        nodes[leftNodeIndex] = node;
        if(node != null)
            node.setParent(this);
    }

    public void setRight(BTNodeEx node) {
        nodes[rightNodeIndex] = node;
        if(node != null)
            node.setParent(this);
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

    public String toText() {
        return String.format("(%s/%s\\%s)", getLeft() != null? getLeft().getValue(): "n", getValue(), getRight() != null? getRight().getValue(): "n");
    }

    public void setParent(BTNodeEx parent) {
        this.parent = parent;
    }

    public BTNodeEx getParent() {
        return parent;
    }

    public boolean leftIsEmpty() {
        return getLeft() == null;
    }

    public boolean rightIsEmpty() {
        return getRight() == null;
    }

    public boolean leftIsLeaf() {
        return leftIsEmpty() && rightIsEmpty();
    }
}
