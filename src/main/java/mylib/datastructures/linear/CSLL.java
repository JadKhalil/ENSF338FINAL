package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class CSLL extends SLL {

    public CSLL() {
        super();
    }

    public CSLL(SNode node) {
        super(node);
        node.next = this.head;
    }

    @Override
    public void InsertHead(SNode node) {
        super.InsertHead(node);
        this.tail.next = this.head;

    }

    public void InsertTail(SNode node) {
        super.InsertTail(node);
        this.tail.next = this.head;

    }

    public void Insert(SNode node, int position) {
        super.Insert(node, position);
    }

    public void Sort() {
        super.Sort();
        this.tail.next = this.head;

    }

    public void SortedInsert(SNode node) {
        super.SortedInsert(node);
    }

    public Boolean isSorted() {
        return super.isSorted();
    }

    public SNode Search(SNode node) {
        return super.Search(node);
    }

    public void Delete(SNode node) {
        if (node == this.head) {
            DeleteHead();
        } else if (node == this.tail) {
            DeleteTail();
        } else {
            super.Delete(node);
        }

    }

    public void DeleteHead() {

        if (this.size == 0) {
            System.out.println("Cannot remove from an empty list");
            return;
        }

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            this.size--;
        } else {
            super.DeleteHead();
            this.tail.next = this.head;
        }

    }

    public void DeleteTail() {
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            this.size--;
        } else {
            super.DeleteTail();
            this.tail.next = this.head;
        }
    }

    public void Clear() {
        super.Clear();
    }

    public void Print() {
        super.Print();
        // SNode ptr = this.head;
        // while (ptr != this.tail) {
        // System.out.println(ptr.data);
        // ptr = ptr.next;
        // }
        // System.out.println(ptr.data);

        if (this.size != 0) {
            System.out.println("Circular ?:");
            System.out.println((this.head == this.tail.next));
        }

    }
}
