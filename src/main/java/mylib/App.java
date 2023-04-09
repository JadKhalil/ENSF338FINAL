package main.java.mylib;

// import main.java.mylib.datastructures.nodes.*;

import main.java.mylib.datastructures.trees.BST;
import main.java.mylib.datastructures.trees.AVL;

class App {

    public static void main(String args[]) {
        AVL avl = new AVL();
        avl.Insert(9);
        avl.Insert(5);
        avl.Insert(10);
        avl.Insert(0);
        avl.Insert(6);
        avl.Insert(11);
        avl.Insert(4);
        avl.Insert(1);
        avl.Insert(2);

        avl.Delete(10);
        avl.Delete(11);
        // System.out.println("before");
        avl.printBF();
        
        // System.out.println(Math.abs(avl.getRoot().getBalance()));

        // avl.Delete(10);
        // avl.Delete(11);

        // System.out.println("after");
        // avl.printBF();
        // System.out.println("b:");
        // System.out.println(Math.abs(avl.getRoot().getBalance()));

    }
}