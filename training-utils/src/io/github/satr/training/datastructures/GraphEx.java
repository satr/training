package io.github.satr.training.datastructures;

import java.util.*;

public class GraphEx <T extends GraphNodeEx<?>> implements Iterator<T>, Iterable<T> {

    private final ArrayList<T> nodes = new ArrayList<>();
    private int cursor = -1;

    @Override
    public boolean hasNext() {
        return (cursor + 1) < nodes.size();
    }

    @Override
    public T next() {
        cursor++;
        if (cursor < nodes.size())
            return nodes.get(cursor);
        cursor = nodes.size() - 1;
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        cursor = -1;
        return this;
    }

    public void add(T node) {
        nodes.add(node);
    }

    public T[] getNodeArray(T[] nodeArray) {
        return nodes.toArray(nodeArray);
    }

    public boolean hasPath(T fromNode, T toNode) {
        HashMap<T, Boolean> visitedNodes = new HashMap<>();
        LinkedList<GraphNodeEx<?>> nodesToVisit = new LinkedList<>();
        nodesToVisit.addFirst(fromNode);
        while(!nodesToVisit.isEmpty()) {
            T node = (T)nodesToVisit.pop();
            if(node == toNode)
                return true;
            if(visitedNodes.containsKey(node) && visitedNodes.get(node))
                continue;
            visitedNodes.put(node, true);
            node.getAdjacent().forEach(nodesToVisit::addFirst);
        }
        return false;
    }
}
