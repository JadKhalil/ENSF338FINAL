package main.java.mylib;

// import main.java.mylib.datastructures.nodes.*;

import main.java.mylib.datastructures.trees.BST;
import main.java.mylib.datastructures.trees.AVL;

class App {

    public static void main(String args[]) {
        AVL avl = new AVL();
        int negativeNum = -1;
        avl.Insert(10);
        avl.Insert(6);
        avl.Insert(11);
        avl.Insert(1);
        avl.Insert(7);
        avl.Insert(12);
        avl.Insert(0);
        avl.Insert(2);
        avl.Insert(3);

        System.out.println("breadth first");
        // avl.Delete(11);
        avl.printBF();

        // System.out.println(avl.getRoot().getLeft().getParent().getData());

        // BST x = new BST();
        // x.Insert(9);
        // x.Insert(5);
        // x.Insert(10);
        // x.Insert(0);
        // x.Insert(6);
        // x.Insert(11);
        // x.Insert(negativeNum);
        // x.Insert(1);
        // x.Insert(2);

        // // x.Delete(10);
        // x.Delete(0);
        // x.Delete(9);
        // x.printBF();

        // System.out.println(x.getRoot().getRight().getParent().getData());

    }
}