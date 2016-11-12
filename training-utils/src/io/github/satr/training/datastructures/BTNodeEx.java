package io.github.satr.training.datastructures;

public class BTNodeEx<TKey> {
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
        return String.format("BTNodeEx{key=%s,data=%s}", key, data);
    }

    public String toText() {
        return String.format("(%s/%s\\%s)", getLeft() != null? getLeft().getKey(): "n", getKey(), getRight() != null? getRight().getKey(): "n");
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

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
