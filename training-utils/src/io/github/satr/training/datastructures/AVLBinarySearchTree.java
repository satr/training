package io.github.satr.training.datastructures;

public class AVLBinarySearchTree<TKey extends Comparable<TKey>> extends BinarySearchTreeBase<TKey, AVLBTNodeEx<TKey>> {
    public AVLBTNodeEx<TKey> insert(TKey key) {
        AVLBTNodeEx<TKey> insertedNode = super.insert(key);
        balanceTree(insertedNode);
        return insertedNode;
    }

    private void balanceTree(AVLBTNodeEx<TKey> insertedNode) {
        BTNodeEx<TKey> node = insertedNode;
        BTNodeEx<TKey> parent;
        while (node != null && node != getRoot()) {
            parent = node.getParent();
            if(parent == null)
                return;
            if(parent.isLeftOverWeighted()) {
                if(node.isRightWeighted()) {
                    leftRotate(node);
                    rightRotate(parent);
                } else {
                    rightRotate(parent);
                }
            } else if(parent.isRightOverWeight()) {
                if(node.isLeftWeighted()) {
                    rightRotate(node);
                    leftRotate(parent);
                } else {
                    leftRotate(parent);
                }
            }
            node = node.getParent();
        }
    }

    private void leftRotate(BTNodeEx<TKey> nodeX) {
        BTNodeEx<TKey> nodeY = nodeX.getRight();
        translateParentBetweenNodes(nodeX, nodeY);
        nodeX.setRight(nodeY.getLeft());
        nodeY.setLeft(nodeX);
    }

    private void rightRotate(BTNodeEx<TKey> nodeX) {
        BTNodeEx<TKey> nodeY = nodeX.getLeft();
        translateParentBetweenNodes(nodeX, nodeY);
        nodeX.setLeft(nodeY.getRight());
        nodeY.setRight(nodeX);
    }

    private void translateParentBetweenNodes(BTNodeEx<TKey> nodeX, BTNodeEx<TKey> nodeY) {
        if(nodeX == getRoot())
            setRoot(nodeY);
        else if(nodeX.getParent().getLeft() == nodeX)
            nodeX.getParent().setLeft(nodeY);
        else
            nodeX.getParent().setRight(nodeY);
    }

    @Override
    public void remove(TKey key) {
        super.remove(key);
        //TODO: to balance
    }

    @Override
    protected AVLBTNodeEx<TKey> createNode(TKey key) {
        return new AVLBTNodeEx<TKey>(key);
    }
}
