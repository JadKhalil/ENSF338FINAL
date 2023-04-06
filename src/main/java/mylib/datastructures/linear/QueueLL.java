
// Queue

package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class QueueLL extends SLL {

    public QueueLL() {
        super();
    }

    public QueueLL(SNode node) {
        super(node);
    }

    public void enqueue(SNode node) {
        super.InsertTail(node);
    }

    public void dequeue() {
        super.DeleteHead();
    }

    public void front() {
        try {
            System.out.println(this.head.data);
        } catch (NullPointerException e) {
            System.out.println("Queue is empty enjoy your lunch break ;)");
        }
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
    public void InsertHead(SNode node) {
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
