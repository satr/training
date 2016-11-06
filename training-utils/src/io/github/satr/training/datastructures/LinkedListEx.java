package io.github.satr.training.datastructures;

public class LinkedListEx {
    private NodeEx first;
    private NodeEx last;

    public boolean isEmpty() {
        return last == null;
    }

    public NodeEx getFirst() {
        return first;
    }

    public void add(NodeEx node) {
        if(first == null)
            first = node;
        if(last == null) {
            last = node;
            return;
        }
        last.setNext(node);
        last = node;
    }

    public void reverse() {
        NodeEx node = getFirst();
        reverse(node);
        node.setNext(null);
        last = node;
    }

    private void reverse(NodeEx node) {
        NodeEx nextNode = node.getNext();
        if(nextNode == null) {
            first = node;
            return;
        }
        reverse(nextNode);
        nextNode.setNext(node);
    }


}
