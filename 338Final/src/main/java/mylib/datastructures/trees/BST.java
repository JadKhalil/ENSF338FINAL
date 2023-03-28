package main.java.mylib.datastructures.trees;

import main.java.mylib.datastructures.nodes.TNode;

public class BST {

    public BST() {
        this.root = null;
    }

    public BST(int val) {
        this.root = new TNode(val, 0, null, null, null);
    }

    public BST(TNode obj) {
        this.root = obj;
    }

    public void setRoot(TNode root) {
        this.root = root;
    }

    public TNode getRoot() {
        return this.root;
    }

    public void Insert(int val) {

    }

    public void Insert(TNode node) {

    }

    private TNode root;
}
