package io.github.satr.training.datastructures;

public class BTNodeEx<TKey extends Comparable<TKey>> {
    BTNodeEx[] nodes = new BTNodeEx[2];
    private int leftNodeIndex = 0;
    private int rightNodeIndex = 1;
    private TKey key;
    private BTNodeEx parent;
    private Object data;

    public BTNodeEx(TKey key) {

        this.key = key;
    }

    public TKey getKey() {
        return key;
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

    public BTNodeEx<TKey> getLeft() {
        return nodes[leftNodeIndex];
    }

    public BTNodeEx<TKey> getRight() {
        return nodes[rightNodeIndex];
    }

    @Override
    public String toString() {
        return String.format("BTNodeEx{key=%s,data=%s}%s", key, data, toText());
    }

    public String toText() {
        return String.format("(%s/%s\\%s)", getLeft() != null? getLeft().getKey(): "n", getKey(), getRight() != null? getRight().getKey(): "n");
    }

    public void setParent(BTNodeEx parent) {
        this.parent = parent;
    }

    public BTNodeEx<TKey> getParent() {
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

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public int getHeight() {
        return 1 + (getRightHeight() >= getLeftHeight() ?  getRightHeight() : getLeftHeight());
    }

    private int getRightHeight() {
        return getRight() == null ? -1 : getRight().getHeight();
    }

    private int getLeftHeight() {
        return getLeft() == null ? -1 : getLeft().getHeight();
    }

    public boolean isLeftOverWeighted() {
        return getLeftHeight() - getRightHeight() >= 2;
    }

    public boolean isRightOverWeight() {
        return getRightHeight() - getLeftHeight() >= 2;
    }

    public boolean isLeftWeighted() {
        return getLeftHeight() - getRightHeight() >= 1;
    }

    public boolean isRightWeighted() {
        return getRightHeight() - getLeftHeight() >= 1;
    }
}
