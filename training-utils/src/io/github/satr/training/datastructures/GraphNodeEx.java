package io.github.satr.training.datastructures;


import java.util.ArrayList;
import java.util.List;

public class GraphNodeEx<T extends Comparable<?>> {
    public List<GraphNodeEx<T>> adjacent = new ArrayList<>();
    private T data;

    public GraphNodeEx(T data) {

        this.data = data;
    }

    @Override
    public String toString() {
        return "data=" + data;
    }

    public void link(GraphNodeEx<T> node) {
        linkTo(node);
        if(!node.adjacent.contains(this))
            node.adjacent.add(this);
    }

    public T getData() {
        return data;
    }

    public void linkTo(GraphNodeEx<T> node) {
        if(!adjacent.contains(node))
            adjacent.add(node);

    }

    public List<GraphNodeEx<T>> getAdjacent() {
        return adjacent;
    }
}
