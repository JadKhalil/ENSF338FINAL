package main.java.mylib.datastructures.nodes;

public class TNode {
    int data;
    TNode left;
    TNode right;
    int balance;

    public TNode() {
        this.left = null;
        this.right = null;
        this.balance = 0;
    }
}
