package io.github.satr.training.datastructures;


public class BinarySearchTree<TKey extends Comparable<TKey>> extends BinarySearchTreeBase<TKey, BTNodeEx<TKey>> {
    @Override
    protected BTNodeEx<TKey> createNode(TKey key) {
        return new BTNodeEx<TKey>(key);
    }
}

