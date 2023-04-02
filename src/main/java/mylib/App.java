package main.java.mylib;

import main.java.mylib.datastructures.linear.DLL;
import main.java.mylib.datastructures.linear.SLL;
import main.java.mylib.datastructures.linear.CSLL;
import main.java.mylib.datastructures.linear.CDLL;
import main.java.mylib.datastructures.nodes.DNode;
import main.java.mylib.datastructures.nodes.SNode;
import main.java.mylib.datastructures.nodes.TNode;
import main.java.mylib.datastructures.linear.QueueLL;

import main.java.mylib.datastructures.trees.BST;
import main.java.mylib.datastructures.trees.AVL;

class App {

    public static void main(String args[]) {

        BST root = new BST();
        root.Insert(6);
        root.Insert(4);
        root.Insert(5);
        root.Insert(1);
        root.Insert(3);
        // root.Insert(5);
        root.Insert(9);
        root.Insert(0);
        root.Insert(-1);
        root.Insert(-2);
        // root.Insert(11);
        // root.Insert(7);

        AVL x = new AVL(root.getRoot());
        // x.printBF();
        // System.out.println("yopfs");
        // x.printInOrder();

        // root.printBF();

        // x.printInOrder();

        // root.Delete(6);
        // root.Delete(11);
        // root.Delete(5);
        // root.Delete(2);
        // root.Delete(-1010101);
        // root.Delete(3);
        // root.Delete(7);
        // root.Delete(9);

        // root.printInOrder();
        // root.printBF();
        // System.out.println("Balance check: ");
        // checkBalance(root.getRoot());
        // ParentCheck(root.getRoot());

    }

    public static void ParentCheck(TNode root) {
        if (root != null) {
            ParentCheck(root.getLeft());
            if (root.getParent() == null) {
                System.out.println("Parent of " + root.getData() + ": null");
            } else {
                System.out.println("Parent of " + root.getData() + ": " + root.getParent().getData());
            }

            ParentCheck(root.getRight());
        }
    }

    public static void checkBalance(TNode root) {
        if (root != null) {
            checkBalance(root.getLeft());
            System.out.println("balance of " + root.getData() + ": " + root.getBalance());
            checkBalance(root.getRight());
        }
    }

}