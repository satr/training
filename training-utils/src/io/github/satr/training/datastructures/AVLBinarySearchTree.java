package io.github.satr.training.datastructures;

public class AVLBinarySearchTree<TKey extends Comparable<TKey>> {
    private AVLBTNodeEx<TKey> root;

    public AVLBTNodeEx<TKey> getRoot() {
        return root;
    }

    public AVLBTNodeEx<TKey> insert(TKey key) {
        AVLBTNodeEx<TKey> node = new AVLBTNodeEx<>(key);
        if(root == null)
            root = node;
        return node; //To be continued...
    }
}
