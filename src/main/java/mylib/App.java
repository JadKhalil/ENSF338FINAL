package main.java.mylib;

// import main.java.mylib.datastructures.nodes.*;

// import main.java.mylib.datastructures.trees.BST;
import main.java.mylib.datastructures.trees.AVL;

class App {

    public static void main(String args[]) {
        AVL avl = new AVL(50);
        avl.Insert(30);
        avl.Insert(20);
        avl.Insert(40);
        avl.Insert(70);
        avl.Insert(60);
        avl.Insert(80);

        avl.printBF();
    }
}