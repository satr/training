package io.github.satr.training.algorithms;

import io.github.satr.training.datastructures.BTNodeEx;

/***************************************************************************
 * Implementation of the Day–Stout–Warren tree balancing algorithm
 * https://en.wikipedia.org/wiki/Day%E2%80%93Stout%E2%80%93Warren_algorithm
 *
 * Modified code from the source: http://www.geekviewpoint.com/java/bst/dsw_algorithm
 *
 * Original code:
 * Author: Isai Damier
 * Title: DSW Algorithm
 * Project: geekviewpoint
 * Package: algorithms
 *
 * Statement:
 *   Transform the given BST into a perfectly balanced BST so that its
 *   height is log n, where n is the number of nodes on the tree.
 *
 *  Time Complexity: O(n)
 *  Space Complexity: O(1)
 *
 **************************************************************************/

public class TreeBalancingDayStoutWarren {
    private BTNodeEx root;

    public TreeBalancingDayStoutWarren(BTNodeEx root) {
        this.root = root;
    }

    public void createVine() {
        BTNodeEx grandParent = null;
        BTNodeEx parent = root;
        BTNodeEx leftChild;

        while (null != parent) {
            leftChild = parent.getLeft();
            if (null != leftChild) {
                grandParent = rotateRight(grandParent, parent, leftChild);
                parent = leftChild;
            } else {
                grandParent = parent;
                parent = parent.getRight();
            }
        }
    }

    private BTNodeEx rotateRight(BTNodeEx grandParent, BTNodeEx parent, BTNodeEx leftChild) {
        if (null != grandParent) {
            grandParent.setRight(leftChild);
        } else {
            setRoot(leftChild);
        }
        parent.setLeft(leftChild.getRight());
        leftChild.setRight(parent);
        return grandParent;
    }

    public void createCompleteBST() {
        int n = 0;
        for (BTNodeEx tmp = root; null != tmp; tmp = tmp.getRight()) {
            n++;
        }
        //m = 2^floor[lg(n+1)]-1, ie the greatest power of 2 less than n: minus 1
        int m = greatestPowerOf2LessThanN(n + 1) - 1;
        makeRotations(n - m);

        while (m > 1) {
            makeRotations(m /= 2);
        }
    }

    /**
     * Time complexity: log(n)
     */
    private int greatestPowerOf2LessThanN(int n) {
        int x = MSB(n);//MSB
        return (1 << x);//2^x
    }

    /**
     * Time complexity: log(n)
     * return the index of most significant set bit: index of
     * least significant bit is 0
     */
    public int MSB(int n) {
        int ndx = 0;
        while (1 < n) {
            n = (n >> 1);
            ndx++;
        }
        return ndx;
    }

    private void makeRotations(int bound) {
        BTNodeEx grandParent = null;
        BTNodeEx parent = root;
        BTNodeEx child = root.getRight();
        for (; bound > 0; bound--) {
            try {
                if (null != child) {
                    rotateLeft(grandParent, parent, child);
                    grandParent = child;
                    parent = grandParent.getRight();
                    child = parent.getRight();
                } else {
                    break;
                }
            } catch (NullPointerException convenient) {
                break;
            }
        }
    }

    private void rotateLeft(BTNodeEx grandParent, BTNodeEx parent, BTNodeEx rightChild) {
        if (null != grandParent) {
            grandParent.setRight(rightChild);
        } else {
            setRoot(rightChild);
        }
        parent.setRight(rightChild.getLeft());
        rightChild.setLeft(parent);
    }

    public BTNodeEx getRoot() {
        return root;
    }

    public void setRoot(BTNodeEx node) {
        this.root = node;
    }
}
