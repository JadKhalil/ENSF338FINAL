
package main.java.mylib.datastructures.nodes;

public class TNode {
    public int data;
    public TNode left;
    public TNode right;
    public TNode parent;
    public int balance;

    public TNode() {
        this.left = null;
        this.right = null;
        this.balance = 0;
    }

    public TNode(int data, int balance, TNode P, TNode L, TNode R) {
        this.data = data;
        this.balance = balance;
        this.parent = P;
        this.left = L;
        this.right = R;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public int getData() {
        return this.data;
    }

    public int getBalance() {
        return this.balance;
    }

    public TNode getParent() {
        return this.parent;
    }

    public TNode getLeft() {
        return this.left;
    }

    public TNode getRight() {
        return this.right;
    }

    public void Print() {

        System.out.println("Information on Node " + this.data);
        System.out.println("left child is" + this.left);
        System.out.println("Right child is " + this.right);
        System.out.println("parent node is " + this.parent);
        if (this.balance > 1 || this.balance < -1)
            System.out.println("node is unbalnced with a balance factor of " + this.balance);
        else
            System.out.println("node is balanced with a balance factor of " + this.balance);
    }

}
