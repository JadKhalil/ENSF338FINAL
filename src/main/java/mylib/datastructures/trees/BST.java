
//  binary search tree

package main.java.mylib.datastructures.trees;

import main.java.mylib.datastructures.nodes.TNode;
import java.util.*;

public class BST {

    public BST() {
        this.root = null;
    }

    public BST(int val) {
        this.root = new TNode(val, 0, null, null, null);
    }

    public BST(TNode obj) {
        this.root = obj;
        height(this.root);
    }

    public void setRoot(TNode root) {
        this.root = root;
    }

    public TNode getRoot() {
        return this.root;
    }

    public void Insert(int val) {
        // just create a new node and call the Insert function with the node
        TNode newNode = new TNode(val, 0, null, null, null);
        Insert(newNode);
    }

    public void Insert(TNode newNode) {
        // in this function we call the recursive implementation of the Insert and save
        // its result
        this.root = InsertRec(this.root, newNode);
        height(this.root);

    }

    private TNode InsertRec(TNode root, TNode newNode) {

        if (root == null)
            return newNode;

        else if (newNode.getData() < root.getData()) {
            // traverse left
            TNode leftChild = InsertRec(root.getLeft(), newNode);
            root.setLeft(leftChild);
            leftChild.setParent(root);

        } else if (newNode.getData() > root.getData()) {
            // traverse right
            TNode rightChild = InsertRec(root.getRight(), newNode);
            root.setRight(rightChild);
            rightChild.setParent(root);
        }
        return root;
    }

    public int height(TNode node) {
        if (node == null)
            return 0;

        int leftH = height(node.getLeft());
        int rightH = height(node.getRight());
        node.setBalance(rightH - leftH);
        return Math.max(rightH, leftH) + 1;

    }

    public void Delete(int val) {

        TNode found = Search(val);

        if (found == null) {
            System.out.println("Cannot find node to delete");
        } else {
            this.root = DeleteRec(this.root, val);
            height(this.root);
        }

    }

    private TNode DeleteRec(TNode root, int val) {
        if (root == null)
            return root;

        if (val < root.getData()) {
            TNode result = DeleteRec(root.getLeft(), val);
            root.setLeft(result);
        } else if (val > root.getData()) {
            TNode result = DeleteRec(root.getRight(), val);
            root.setRight(result);
        } else {

            if (root.getLeft() == null)
                return root.getRight();
            else if (root.getRight() == null)
                return root.getLeft();

            root.setData(minValue(root.getRight()));

            TNode inOrderDel = DeleteRec(root.getRight(), root.getData());
            root.setRight(inOrderDel);
        }

        return root;
    }

    public int minValue(TNode root) {
        int minV = root.getData();
        while (root.getLeft() != null) {
            minV = root.getLeft().getData();
            root = root.getLeft();
        }
        return minV;
    }

    public TNode Search(int val) {

        TNode rootPtr = this.root;

        while (rootPtr != null) {
            if (rootPtr.getData() == val)
                return rootPtr;
            else if (rootPtr.getData() > val)
                rootPtr = rootPtr.getLeft();
            else
                rootPtr = rootPtr.getRight();

        }

        return null;
    }

    public void printInOrder() {
        inOrder(this.root);
    }

    private void inOrder(TNode root) {

        if (root != null) {
            inOrder(root.getLeft());
            System.out.println(root.getData());
            inOrder(root.getRight());
        }

    }

    public void printBF() {
        // to print each level on a seperate line use two qeueue ?!?!?!?!
        // let me explain:
        // have one queue that has the current level
        // have another queue that has the next level

        if (this.root == null) {
            System.out.println("empty tree");
            return;
        }

        Queue<TNode> queue = new LinkedList<TNode>();
        Queue<TNode> nextLevel = new LinkedList<TNode>();
        StringBuilder display = new StringBuilder();

        queue.add(this.root);

        while (!queue.isEmpty()) {

            TNode front = queue.peek();
            display.append(front.getData());

            if (front.getLeft() != null)
                nextLevel.add(front.getLeft());
            if (front.getRight() != null)
                nextLevel.add(front.getRight());

            queue.remove();
            if (queue.isEmpty()) {
                System.out.println(display);

                // now copy the elements from nextLevel to queue
                while (!nextLevel.isEmpty()) {
                    queue.add(nextLevel.peek());
                    nextLevel.remove();
                }
                display.setLength(0);
            }
        }

    }

    protected TNode root;
}