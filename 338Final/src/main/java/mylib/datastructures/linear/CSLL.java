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
        super.Delete(node);
    }

    public void DeleteHead() {
        super.DeleteHead();
        this.tail.next = this.head;
    }

    public void DeleteTail() {
        super.DeleteTail();
        this.tail.next = this.head;
    }

    public void Clear() {
        super.Clear();
    }

    public void Print() {
        super.Print();
    }
}
