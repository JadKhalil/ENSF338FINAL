
package main.java.mylib.datastructures.nodes;

public class DNode {
    public int data;
    public DNode next;
    public DNode prev;

    public DNode() {
        this.next = null;
        this.prev = null;
    }

    public DNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
