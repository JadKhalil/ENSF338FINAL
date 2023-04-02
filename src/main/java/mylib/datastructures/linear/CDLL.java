package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class CDLL extends DLL {

    public CDLL() {
        super();
    }

    public CDLL(DNode node) {
        super(node);
        node.next = this.head;
        node.prev = this.head;
    }

    public void InsertHead(DNode node) {
        super.InsertHead(node);
        this.head.prev = this.tail;
        this.tail.next = this.head;
    }

    public void InsertTail(DNode node) {
        super.InsertTail(node);
        this.head.prev = this.tail;
        this.tail.next = this.head;
    }

    public void Insert(DNode node, int position) {
        super.Insert(node, position);
    }

    public Boolean isSorted() {
        return super.isSorted();
    }

    public void Sort() {
        super.Sort();
        this.tail.next = this.head;
    }

    public void SortedInsert(DNode node) {
        super.SortedInsert(node);
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
            this.head.prev = this.tail;
            this.tail.next = this.head;
        }

    }

    public void DeleteTail() {

        if (this.size == 0) {
            System.out.println("Cannot remove from an empty list");
            return;
        }

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            this.size--;
        } else {
            super.DeleteTail();
            this.head.prev = this.tail;
            this.tail.next = this.head;
        }
    }

    public void Delete(DNode node) {
        if (node == this.head) {
            DeleteHead();
        } else if (node == this.tail) {
            DeleteTail();
        } else {
            super.Delete(node);
        }
    }

    public DNode Search(DNode node) {
        return super.Search(node);
    }

    public void Clear() {
        super.Clear();
    }

    public void Print() {
        super.Print();

        if (this.size != 0) {
            System.out.println("Circular from head->tail:");
            System.out.println(this.head.prev == this.tail);

            System.out.println("Circular from tail->head:");
            System.out.println(this.tail.next == this.head);

        }

    }

}
