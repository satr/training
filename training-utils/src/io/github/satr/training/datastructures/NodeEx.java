package io.github.satr.training.datastructures;

public class NodeEx<T> {
    public NodeEx() {
    }

    public NodeEx(T data) {
        setData(data);
    }

    private T data;
    private NodeEx next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
