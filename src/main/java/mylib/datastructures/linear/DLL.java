
// Doubly linked list

package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class DLL {
    public DNode head;
    public DNode tail;
    public int size;

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
            this.size++;
        }

    }

    public void DeleteHead() {

        try {

            if (--this.size == 0) {
                this.head = null;
                this.tail = null;
            } else {
                DNode ptr = this.head;
                this.head = ptr.next;
                this.head.prev = null;
                ptr.next = null;
            }

        } catch (NullPointerException e) {
            System.out.println("Cannot remove from an empty list");
        }

    }

    public void DeleteTail() {
        try {
            if (--this.size == 0) {
                this.head = null;
                this.tail = null;
            } else {
                DNode ptr = this.tail.prev;
                ptr.next = null;
                this.tail.prev = null;
                this.tail = ptr;
            }

        } catch (NullPointerException e) {
            System.out.println("Cannot remove from an empty list");
        }

    }

    public void Delete(DNode node) {
        if (node == this.head) {
            DeleteHead();
        } else if (node == this.tail) {
            DeleteTail();
        } else {
            DNode ptr = this.head.next;
    
            while (ptr != null) {
                if (ptr == node) {
                    DNode prevPtr = ptr.prev;
                    DNode nextPtr = ptr.next;
    
                    prevPtr.next = nextPtr;
                    nextPtr.prev = prevPtr;
    
                    ptr.prev = null;
                    ptr.next = null;
    
                    this.size--;
                    break;
                }
                ptr = ptr.next;
            }
        }
    }    

    public void Sort() {
        if (this.size == 0 || this.size == 1)
            return;

        // inserting a dummy node will limit the sorting to have only 1 edge case
        DNode dummy = new DNode(Integer.MIN_VALUE);
        DNode curr = this.head.next;
        DNode prevPtr = this.head;
        InsertHead(dummy);
        Boolean swap = false;

        while (curr != this.tail.next) {

            while (prevPtr != this.head && prevPtr.data > curr.data) {
                prevPtr = prevPtr.prev;
                swap = true;
            }

            if (swap) {
                if (curr == this.tail) {
                    DNode prevNext = prevPtr.next;

                    this.tail = curr.prev;

                    prevPtr.next = curr;
                    curr.prev = prevPtr;

                    curr.next = prevNext;
                    prevNext.prev = curr;

                    this.tail.next = null;

                } else {
                    DNode currNext = curr.next;
                    DNode currPrev = curr.prev;
                    DNode nextPrev = prevPtr.next;

                    curr.next = nextPrev;
                    prevPtr.next = curr;
                    curr.prev = prevPtr;
                    nextPrev.prev = curr;

                    currPrev.next = currNext;
                    currNext.prev = currPrev;

                    curr = currNext.prev;
                }
                swap = false;
            }
            prevPtr = curr;
            curr = curr.next;

        }

        // delete the dummy node
        DeleteHead();
    }

    public void SortedInsert(DNode node) {

        if (!isSorted()) {
            Sort();
        }

        DNode ptr = this.head;
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
        if (this.size == 1 || this.size == 0) {
            return true;
        }

        DNode ptr = this.head;
        int prev = ptr.data;
        ptr = ptr.next;

        if (this instanceof CDLL) {
            while (ptr != this.head) {
                if (ptr.data < prev) {
                    return false;
                }
                prev = ptr.data;
                ptr = ptr.next;
            }
        } else {
            while (ptr != null) {
                if (ptr.data < prev) {
                    return false;
                }
                prev = ptr.data;
                ptr = ptr.next;
            }
        }

        return true;
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
        System.err.println("Forward Iteration:");
        DNode ptr = this.head;
        int i = 0;
        while (i < this.size) {
            System.out.println(ptr.data);
            ptr = ptr.next;
            i++;
        }
        i = 0;
        ptr = this.tail;
        System.out.println("BackWards Iteration: ");
        while (i < this.size) {
            System.out.println(ptr.data);
            ptr = ptr.prev;
            i++;
        }
    }

}
