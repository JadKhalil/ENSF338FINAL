package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class DLL {

    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DLL(DNode node) {
        this.head = node;
        this.tail = node;
        this.size = 1;
    }

    public void InsertHead(DNode node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;

        } else {
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }

        this.size++;
    }

    public void InsertTail(DNode node) {
        if (this.tail == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }

        this.size++;
    }

    public void Insert(DNode node, int position) {
        if (position == 0) {
            InsertHead(node);
            return;
        } else if (position >= this.size) {
            InsertTail(node);
            return;
        } else {
            DNode ptr = this.head;
            DNode prevPtr;
            int i = 0;
            while (i != position) {
                i++;
                ptr = ptr.next;
            }
            prevPtr = ptr.prev;

            node.next = ptr;
            node.prev = prevPtr;

            prevPtr.next = node;
            ptr.prev = node;
        }

        this.size++;
    }

    public void DeleteHead() {
        try {
            DNode ptr = this.head;
            this.head = ptr.next;
            this.head.prev = null;
            ptr.next = null;

        } catch (NullPointerException e) {
            System.out.println("Cannot remove from an empty list");
        }
        this.size--;
    }

    public void DeleteTail() {
        try {
            DNode ptr = this.tail.prev;
            ptr.next = null;
            this.tail.prev = null;
            this.tail = ptr;

        } catch (NullPointerException e) {
            System.out.println("Cannot remove from an empty list");
        }
        this.size--;
    }

    public void Delete(DNode node) {

    }

    public void Sort() {

    }

    public void SortedInsert(DNode node) {
        // to finish

    }

    public DNode Search(DNode node) {

        DNode ptr = this.head;
        // DNode tailptr = this.tail;

        while (ptr != null) {
            if (ptr == node)
                return ptr;
            ptr = ptr.next;
        }

        return null;
    }

    public void Clear() {
        try {
            DNode nextNode = this.head.next;
            while (this.head != this.tail) {
                this.head.next = null;
                this.head = nextNode;
                nextNode = nextNode.next;
            }
        } catch (NullPointerException e) {
            System.out.println("Cannot remove from an empty list");
        }

        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void Print() {

    }

    private DNode head;
    private DNode tail;
    int size;
}
