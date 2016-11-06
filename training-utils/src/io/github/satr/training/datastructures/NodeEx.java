package io.github.satr.training.datastructures;

public class NodeEx {
    public NodeEx() {
    }

    public NodeEx(int data) {
        setData(data);
    }

    private int data;
    private NodeEx next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(NodeEx next) {
        this.next = next;
    }

    public NodeEx getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "NodeEx{" + "data=" + data + '}';
    }
}
