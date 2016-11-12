package io.github.satr.training.datastructures;

import java.util.ArrayList;
import java.util.List;

public class HashTableEx<TKey extends Comparable<TKey>, TValue> {

    private BTNodeEx<TKey> root;

    public boolean isEmpty() {
        return root == null;
    }

    public TValue get(TKey key) {
        if (isEmpty())
            return null;
        return getDataByKey(key, root);
    }

    public void put(TKey key, TValue value) {
        if(root == null) {
            root = createNode(key);
            putValueToData(value, key, root.getData());
            return;
        }
        put(root, key, value);
    }

    public void remove(TKey key) {
        remove(key, root);
    }

    private void remove(TKey key, BTNodeEx<TKey> node) {
        int keyHashCode = getHashCode(key);
        if(getHashCode(node.getKey()) == keyHashCode) {
            List<KeyValuePair> data = (List<KeyValuePair>) node.getData();
            KeyValuePair pair = getKeyValuePair(key, data);
            if(key != null)
                data.remove(pair);
            return;
        }
        if(node.getLeft() != null && getHashCode(node.getLeft().getKey()) >= keyHashCode)
            remove(key, node.getLeft());
        if(node.getRight() != null && getHashCode(node.getRight().getKey()) <= keyHashCode)
            remove(key, node.getRight());
    }

    private TValue getDataByKey(TKey key, BTNodeEx<TKey> node) {
        int keyHashCode = getHashCode(key);
        if(getHashCode(node.getKey()) == keyHashCode)
            return getValueFromData(key, node.getData());
        if(node.getLeft() != null && getHashCode(node.getLeft().getKey()) >= keyHashCode)
            return (TValue) getDataByKey(key, node.getLeft());
        if(node.getRight() != null && getHashCode(node.getRight().getKey()) <= keyHashCode)
            return (TValue) getDataByKey(key, node.getRight());
        return null;
    }

    private void put(BTNodeEx<TKey> node, TKey key, TValue value) {
        int keyHashCode = getHashCode(key);
        if(getHashCode(node.getKey()) == keyHashCode)
            putValueToData(value, key, node.getData());
        else if(getHashCode(node.getKey()) > keyHashCode)
            addToLeft(node, key, value);
        else if(node.getRight() == null)
            addToRight(node, key, value);
        else
            put(node.getRight(), key, value);
    }

    private void addToRight(BTNodeEx<TKey> node, TKey key, TValue value) {
        node.setRight(createNode(key));
        putValueToData(value, key, node.getRight().getData());
    }

    private void addToLeft(BTNodeEx<TKey> node, TKey key, TValue value) {
        if (node.getLeft() != null) {
            put(node.getLeft(), key, value);
            return;
        }
        node.setLeft(createNode(key));
        putValueToData(value, key, node.getLeft().getData());
    }

    private int getHashCode(TKey key) {
        return key == null ? 0 : key.hashCode();
    }

    private BTNodeEx<TKey> createNode(TKey key) {
        BTNodeEx node = new BTNodeEx(key);
        ArrayList<KeyValuePair> data = new ArrayList<>();
        node.setData(data);
        return node;
    }

    private void putValueToData(TValue value, TKey key, Object nodeData) {
        List<KeyValuePair> data = (List<KeyValuePair>) nodeData;
        for (KeyValuePair pair: data) {
            if(pair.key != key)
                continue;
            pair.value = value;
            return;
        }
        data.add(new KeyValuePair(key, value));
    }

    private TValue getValueFromData(TKey key, Object nodeData) {
        List<KeyValuePair> data = (List<KeyValuePair>) nodeData;
        KeyValuePair pair = getKeyValuePair(key, data);
        return pair != null ? pair.value : null;
    }

    private KeyValuePair getKeyValuePair(TKey key, List<KeyValuePair> data) {
        for (KeyValuePair pair: data) {
            if(pair.key == key)
                return pair;
        }
        return null;
    }

    private class KeyValuePair {
        private TKey key;
        private TValue value;

        public KeyValuePair(TKey key, TValue value) {

            this.key = key;
            this.value = value;
        }
    }
}
