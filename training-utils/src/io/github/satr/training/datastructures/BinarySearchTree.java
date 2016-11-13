package io.github.satr.training.datastructures;


public class BinarySearchTree<TKey extends Comparable<TKey>> {
    BTNodeEx<TKey> parentOfRoot = new BTNodeEx<TKey>(null);

    public BTNodeEx<TKey> insert(TKey key) {
        BTNodeEx<TKey> node = new BTNodeEx<>(key);
        if(getRoot() == null)
            setRoot(node);
        else
            insert(node, getRoot());
        return node;
    }

    private void insert(BTNodeEx<TKey> node, BTNodeEx<TKey> existingNode) {
        if(node.getKey().compareTo(existingNode.getKey()) < 0) {
            if(existingNode.getLeft() == null)
                existingNode.setLeft(node);
            else
                insert(node, existingNode.getLeft());
        } else if(node.getKey().compareTo(existingNode.getKey()) > 0) {
            if (existingNode.getRight() == null)
                existingNode.setRight(node);
            else
                insert(node, existingNode.getRight());
        }
    }

    public BTNodeEx<TKey> getRoot() {
        return parentOfRoot.getRight();
    }

    private void setRoot(BTNodeEx<TKey> node) {
        parentOfRoot.setRight(node);
    }

    public void remove(TKey key) {
        remove(key, parentOfRoot, getRoot());
    }

    private void remove(TKey key, BTNodeEx<TKey> parent, BTNodeEx<TKey> node) {
        if(node == null)
            return;
        BTNodeEx<TKey> nodeRight = node.getRight();
        if(key.compareTo(node.getKey()) < 0) {
            remove(key, node, node.getLeft());
            return;
        }
        if(key.compareTo(node.getKey()) > 0) {
            remove(key, node, nodeRight);
            return;
        }
        BTNodeEx<TKey> minNode = getMinNodeUnder(nodeRight);
        if (minNode != null) {
            if(nodeRight.getLeft() == minNode)
                nodeRight.setLeft(minNode.getRight());
            if(minNode != nodeRight)
                minNode.setRight(nodeRight);
            minNode.setLeft(node.getLeft());
        } else {
            minNode = node.getLeft();
        }
        if(parent.getLeft() == node)
            parent.setLeft(minNode);
        else
            parent.setRight(minNode);
    }

    private BTNodeEx<TKey> getMinNodeUnder(BTNodeEx<TKey> node) {
        if(node == null)
            return null;
        if (node.getLeft() == null)
            return node;
        return getMinNodeUnder(node.getLeft());
    }
}
