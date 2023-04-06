
package test.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.linear.SLL;
import main.java.mylib.datastructures.nodes.SNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SLLTest {

    SLL sll;

    @BeforeEach
    void setUp() {
        sll = new SLL();
    }

    @Test
    void testInsertHead() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);

        sll.InsertHead(node1);
        assertEquals(1, sll.size);
        assertEquals(node1, sll.head);
        assertEquals(node1, sll.tail);

        sll.InsertHead(node2);
        assertEquals(2, sll.size);
        assertEquals(node2, sll.head);
        assertEquals(node1, sll.tail);
        assertEquals(node1, node2.next);
    }

    @Test
    void testInsertTail() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);

        sll.InsertTail(node1);
        assertEquals(1, sll.size);
        assertEquals(node1, sll.head);
        assertEquals(node1, sll.tail);

        sll.InsertTail(node2);
        assertEquals(2, sll.size);
        assertEquals(node1, sll.head);
        assertEquals(node2, sll.tail);
        assertEquals(node2, node1.next);
    }

    @Test
    void testInsert() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        sll.Insert(node1, 0);
        sll.Insert(node2, 1);
        sll.Insert(node3, 1);

        assertEquals(3, sll.size);
        assertEquals(node1, sll.head);
        assertEquals(node2, sll.tail);
        assertEquals(node3, node1.next);
        assertEquals(node2, node3.next);
    }

    @Test
    void testSort() {
        SNode node1 = new SNode(3);
        SNode node2 = new SNode(1);
        SNode node3 = new SNode(2);

        sll.InsertHead(node1);
        sll.InsertHead(node2);
        sll.InsertHead(node3);

        sll.Sort();
        assertEquals(3, sll.size);
        assertEquals(node2, sll.head);
        assertEquals(node1, sll.tail);
        assertEquals(node3, node2.next);
        assertEquals(node1, node3.next);
    }

    @Test
    public void testSortedInsert() {
        SLL sll = new SLL();
        sll.SortedInsert(new SNode(4));
        sll.SortedInsert(new SNode(1));
        sll.SortedInsert(new SNode(3));
        sll.SortedInsert(new SNode(2));

        assertEquals(4, sll.size);

        SNode currentNode = sll.head;
        for (int i = 1; i <= 4; i++) {
            assertEquals(i, currentNode.data);
            currentNode = currentNode.next;
        }
    }

    @Test
    void testIsSorted() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        sll.InsertHead(node1);
        sll.InsertHead(node2);
        sll.InsertHead(node3);

        assertFalse(sll.isSorted());

        sll.Sort();
        assertTrue(sll.isSorted());
    }

    @Test
    void testSearch() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        sll.InsertHead(node1);
        sll.InsertHead(node2);
        sll.InsertHead(node3);

        assertEquals(node2, sll.Search(node2));
        assertNull(sll.Search(new SNode(4)));
    }

    @Test
    public void testDelete() {
        SLL sll = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        SNode node4 = new SNode(4);
        sll.InsertTail(node1);
        sll.InsertTail(node2);
        sll.InsertTail(node3);
        sll.InsertTail(node4);

        // Delete the head node
        sll.Delete(node1);
        assertEquals(3, sll.size);
        assertEquals(node2, sll.head);

        // Delete a middle node
        sll.Delete(node3);
        assertEquals(2, sll.size);
        assertEquals(node4, node2.next);

        // Delete the tail node
        sll.Delete(node4);
        assertEquals(1, sll.size);
        assertEquals(node2, sll.head);
        assertNull(node2.next);

        // Delete the last remaining node
        sll.Delete(node2);
        assertEquals(0, sll.size);
        assertNull(sll.head);
    }

    @Test
    void testDeleteHead() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        sll.InsertHead(node1);
        sll.InsertHead(node2);
        sll.InsertHead(node3);

        sll.DeleteHead();
        assertEquals(2, sll.size);
        assertEquals(node2, sll.head);
        assertEquals(node1, sll.tail);
    }

    @Test
    void testDeleteTail() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        sll.InsertHead(node1);
        sll.InsertHead(node2);
        sll.InsertHead(node3);

        sll.DeleteTail();
        assertEquals(2, sll.size);
        assertEquals(node3, sll.head);
        assertEquals(node2, sll.tail);
    }

    @Test
    void testClear() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        sll.InsertHead(node1);
        sll.InsertHead(node2);
        sll.InsertHead(node3);

        sll.Clear();
        assertEquals(0, sll.size);
        assertNull(sll.head);
        assertNull(sll.tail);
    }
}

