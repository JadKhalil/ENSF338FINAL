package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class StackLL extends SLL {

    public StackLL() {
        super();
    }

    public StackLL(SNode node) {
        super(node);
    }

    public void push(SNode node) {
        super.InsertHead(node);
    }

    public void peek() {
        try {
            System.out.println(this.head.data);
        } catch (NullPointerException e) {
            System.out.println("cannot peek empty stack");
        }
    }

    public void pop() {

        super.DeleteHead();

    }

    public void Clear() {
        super.Clear();
    }

    @Override
    public void DeleteTail() {

    }

    @Override
    public void Delete(SNode node) {

    }

    @Override
    public void InsertTail(SNode node) {
    }

    @Override
    public void Insert(SNode node, int position) {
    }

    @Override
    public void SortedInsert(SNode node) {
    }

    @Override
    public void Print() {

    }

    @Override
    public SNode Search(SNode node) {
        return null;
    }

    @Override
    public void Sort() {
    }

}
