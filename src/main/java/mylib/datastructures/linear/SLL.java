
// Singly linked list

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
        int i = 0;

        // curr != this.tail.next
        while (i < this.size) {

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
                        curr = sortedPtr;

                    } else {
                        SNode nextCurr = curr.next;

                        prev.next = curr;
                        curr.next = sortedPtr;
                        sortedPtr.next = prevCurr;
                        prevCurr.next = nextCurr;

                    }
                    curr = prevCurr;
                    break;

                }

                prev = sortedPtr;
                sortedPtr = sortedPtr.next;

            }
            prev = this.head;
            sortedPtr = this.head;
            prevCurr = curr;
            curr = curr.next;
            i++;
        }

    }

    public void SortedInsert(SNode node) {

        if (!isSorted()) {
            Sort();
        }

        SNode ptr = this.head;
        Boolean inserted = false;
        int i = 0;

        while (i < this.size && !inserted) {
            if (ptr.data < node.data)
                ptr = ptr.next;
            else {
                Insert(node, i);
                inserted = true;
            }
            i++;
        }
        if (!inserted)
            InsertTail(node);
    }

    public Boolean isSorted() {

        if (this.size == 1 || this.size == 0)
            return true;

        SNode ptr = this.head;
        int prev = ptr.data;
        ptr = ptr.next;

        while (ptr != null) {
            if (ptr.data < prev)
                return false;
            prev = ptr.data;
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
            this.DeleteHead();
    
        } else if (this.tail == node) {
            this.DeleteTail();
    
        } else {
            SNode ptr = this.head;
            while (ptr.next != null) {
                if (ptr.next == node) {
                    SNode nextPtr = ptr.next;
                    ptr.next = nextPtr.next;
                    nextPtr.next = null;
                    this.size--; // Decrement the list size
                    return; // Exit the method after successful deletion
                }
                ptr = ptr.next;
            }
        }
    }
    
    public void DeleteHead() {

        if (size == 0) {
            System.out.println("Cannot remove from an empty list");
            return;
        }

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            size = 0;
        } else {

            SNode ptr = this.head;
            this.head = ptr.next;
            ptr.next = null;
            this.size--;

        }

    }

    public void DeleteTail() {

        if (this.size == 0) {
            System.out.println("cannot remove from an empty list");
            return;
        }

        if (this.tail == this.head) {
            this.head = null;
            this.tail = null;
            this.size = 0;
        } else {
            SNode ptr = this.head;
            while (ptr.next != this.tail)
                ptr = ptr.next;
            ptr.next = null;
            this.tail = ptr;
            this.size--;
        }

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

        // int i = 0;
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

    public SNode head;
    public SNode tail;
    public int size;
}
