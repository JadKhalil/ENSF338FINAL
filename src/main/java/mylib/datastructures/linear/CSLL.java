
// Circular Singly linked list

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
        if (size <= 1) {
            return;
        }
    
        SNode currentNode;
        SNode nextNode;
        int temp;
    
        for (int i = 0; i < size - 1; i++) {
            currentNode = head;
            nextNode = head.next;
    
            for (int j = 0; j < size - 1; j++) {
                if (currentNode.data > nextNode.data) {
                    temp = currentNode.data;
                    currentNode.data = nextNode.data;
                    nextNode.data = temp;
                }
                currentNode = nextNode;
                nextNode = nextNode.next;
            }
        }
    }    

    // public void Sort() {
    //     if (size <= 1) {
    //         return;
    //     }
    
    //     // Break the circular reference before sorting
    //     tail.next = null;
    
    //     // Sort the list using the SLL Sort() method
    //     super.Sort();
    
    //     // Update the tail's next reference to the head after sorting
    //     tail.next = head;
    // }    

    // public void Sort() {
    //     super.Sort();
    //     this.tail.next = this.head;

    // }

    public void SortedInsert(SNode node) {
        super.SortedInsert(node);
    }

    @Override
    public Boolean isSorted() {
        if (this.size == 1 || this.size == 0) {
            return true;
        }

        SNode ptr = this.head;
        int prev = ptr.data;
        ptr = ptr.next;

        for (int i = 1; i < this.size; i++) {
            if (ptr.data < prev) {
                return false;
            }
            prev = ptr.data;
            ptr = ptr.next;
        }

        return true;
    }

    // public Boolean isSorted() {
    //     return super.isSorted();
    // }

    @Override
    public SNode Search(SNode node) {

        SNode ptr = this.head;
        int i = 0;

        while (ptr != null && i < this.size) {
            if (ptr == node) {
                return ptr;
            }
            ptr = ptr.next;
            i++;
        }

        return null;
    }

    // public SNode Search(SNode node) {
    //     return super.Search(node);
    // }

    public void Delete(SNode node) {
        if (this.head == null) {
            System.out.println("Cannot remove from an empty list");
            return;
        }
    
        if (this.head == node) {
            DeleteHead();
        } else if (this.tail == node) {
            DeleteTail();
        } else {
            SNode ptr = this.head;
            int i = 0;
            while (i < this.size - 1) {
                if (ptr.next == node) {
                    ptr.next = ptr.next.next;
                    this.size--;
                    break;
                }
                ptr = ptr.next;
                i++;
            }
        }
    }    

    // public void Delete(SNode node) {
    //     if (node == this.head) {
    //         DeleteHead();
    //     } else if (node == this.tail) {
    //         DeleteTail();
    //     } else {
    //         super.Delete(node);
    //     }

    // }

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
