package main.java.mylib;

import main.java.mylib.datastructures.linear.DLL;
import main.java.mylib.datastructures.linear.SLL;
import main.java.mylib.datastructures.nodes.SNode;
import main.java.mylib.datastructures.linear.QueueLL;

class App {

    public static void main(String args[]) {

        SLL x = new SLL();
        SNode node = new SNode(8);
        SNode node2 = new SNode(2);
        x.InsertHead(node2);
        x.InsertHead(node);
        System.out.println("Before sort");
        x.Print();
        // SNode node3 = new SNode(9);
        // x.InsertTail(node3);
        // SNode node4 = new SNode(4);
        // x.InsertTail(node4);
        // SNode node5 = new SNode(5);
        // x.Insert(node5, 2);
        // SNode node6 = new SNode(3);
        // x.Insert(node6, 3);
        // SNode node7 = new SNode(1);
        // x.Insert(node7, 2);

        // x.DeleteHead();
        // x.DeleteTail();
        // x.Delete(node3);
        x.Sort();
        // SNode node8 = new SNode(6);
        // x.SortedInsert(node8);
        // SNode node9 = new SNode(11);
        // x.SortedInsert(node9);
        System.out.println("After sort");
        x.Print();

        // QueueLL stack = new QueueLL();
        // stack.enqueue(node7);
        // stack.enqueue(node5);
        // stack.front();
        // stack.dequeue();
        // stack.equals(node2);

        // stack.dequeue();
        // stack.front();

    }
}