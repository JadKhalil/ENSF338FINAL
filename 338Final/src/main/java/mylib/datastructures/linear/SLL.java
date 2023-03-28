package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class SLL {

    public SLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public SLL(SNode node) {
        this.head = node;
        this.tail = node;
        this.size++;
    }

    public void InsertHead(SNode node) {

        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }

        this.size++;
    }

    public void InsertTail(SNode node) {

        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }

        this.size++;
    }

    public void Insert(SNode node, int position) {
        if (position == 0) {
            InsertHead(node);
            return;
        }
        if (position >= this.size) {
            InsertTail(node);
            return;
        }

        int i = 0;
        SNode ptr = this.head;
        while (i + 1 != position) {
            ptr = ptr.next;
            i++;
        }
        node.next = ptr.next;
        ptr.next = node;
        this.size++;

    }

    public void Sort() {

        SNode curr = this.head;
        SNode prevCurr = this.head;
        SNode sortedPtr = this.head;
        SNode prev = this.head;

        while (curr != this.tail.next) {

            while (curr != sortedPtr) {
                // swap here !
                if (sortedPtr.data > curr.data) {
                    // make another pointer to help with node swap
                    if (curr == this.tail && sortedPtr == this.head) {
                        this.head = curr;
                        this.head.next = prev;
                        // curr.next = prev;
                        prev.next = null;
                        this.tail = prev;
                    } else if (curr == this.tail) {
                        this.tail = prevCurr;
                        prev.next = curr;
                        this.tail.next = null;
                        curr.next = sortedPtr;
                    } else if (sortedPtr == this.head) {
                        prevCurr.next = curr.next;
                        curr.next = sortedPtr;
                        this.head = curr;

                    } else {
                        SNode nextCurr = curr.next;

                        prev.next = curr;
                        curr.next = sortedPtr;
                        sortedPtr.next = prevCurr;
                        prevCurr.next = nextCurr;

                        curr = prevCurr;
                    }

                    // System.out.println("after sort:");
                    // Print();
                    break;

                }
                // System.out.println("here nigga");
                prev = sortedPtr;
                sortedPtr = sortedPtr.next;

            }
            prev = this.head;
            sortedPtr = this.head;
            prevCurr = curr;
            curr = curr.next;
        }

    }

    public void SortedInsert(SNode node) {

        // first check if list is empty
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            Boolean sorted = isSorted();
            Boolean inserted = false;
            if (!sorted)
                Sort();

            // check if need to be inserted at head
            if (node.data <= this.head.data) {
                node.next = this.head;
                this.head = node;
                inserted = true;
            }

            int i = 1;
            SNode ptr = this.head;
            while (i < this.size && !inserted) {
                if (node.data <= ptr.next.data) {
                    node.next = ptr.next;
                    ptr.next = node;
                    inserted = true;
                }
                ptr = ptr.next;
                i++;
            }

            if (!inserted) {
                this.tail.next = node;
                this.tail = node;
            }
            this.size++;
        }

        System.out.println("size:");
        System.out.println(this.size);
    }

    public Boolean isSorted() {

        SNode ptr = this.head;

        while (ptr != this.tail) {
            if (ptr.data > this.tail.data)
                return false;
            ptr = ptr.next;
        }

        return true;
    }

    public SNode Search(SNode node) {

        SNode ptr = this.head;

        while (ptr != null) {
            if (ptr == node)
                return ptr;
            ptr = ptr.next;
        }

        return null;
    }

    public void Delete(SNode node) {

        if (this.head == node) {
            DeleteHead();
            return;
        } else if (this.tail == node) {
            DeleteTail();
            return;
        } else {
            SNode ptr = this.head;
            SNode toDel;
            while (ptr.next != node)
                ptr = ptr.next;
            toDel = ptr.next;
            ptr.next = toDel.next;
            toDel.next = null;
            this.size--;
        }

    }

    public void DeleteHead() {
        try {
            SNode ptr = this.head;
            this.head = ptr.next;
            ptr.next = null;

        } catch (NullPointerException e) {
            System.out.println("Cannot remove from an empty list");
        }
        this.size--;
    }

    public void DeleteTail() {
        SNode ptr = this.head;

        try {
            while (ptr.next != this.tail)
                ptr = ptr.next;
            ptr.next = null;
            this.tail = ptr;
        } catch (NullPointerException e) {
            System.out.println("Cannot remove from an empty list");
        }
        this.size--;
    }

    public void Clear() {

        try {
            SNode nextNode = this.head.next;
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

        int i = 0;
        if (this.size == 0) {
            System.out.println("Empty list stuff");
        } else {
            SNode ptr = this.head;
            while (ptr != this.tail) {
                System.out.println(ptr.data);
                ptr = ptr.next;
            }
            System.out.println(ptr.data);
        }

    }

    protected SNode head;
    protected SNode tail;
    int size;
}
