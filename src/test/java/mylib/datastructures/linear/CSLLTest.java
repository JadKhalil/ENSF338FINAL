
package test.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.linear.CSLL;
import main.java.mylib.datastructures.nodes.SNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSLLTest {
    private CSLL csll;

    @BeforeEach
    void setUp() {
        csll = new CSLL();
    }

    @Test
    void testInsertHead() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        csll.InsertHead(node1);
        csll.InsertHead(node2);
        csll.InsertHead(node3);

        assertEquals(3, csll.size);
        assertEquals(node3, csll.head);
        assertEquals(node1, csll.tail);
        assertEquals(node3, csll.tail.next);
    }

    @Test
    void testInsertTail() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        csll.InsertTail(node1);
        csll.InsertTail(node2);
        csll.InsertTail(node3);

        assertEquals(3, csll.size);
        assertEquals(node1, csll.head);
        assertEquals(node3, csll.tail);
        assertEquals(node1, csll.tail.next);
    }

    @Test
    void testInsert() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        csll.InsertHead(node1);
        csll.InsertHead(node2);
        csll.Insert(node3, 1);

        assertEquals(3, csll.size);
        assertEquals(node2, csll.head);
        assertEquals(node1, csll.tail);
        assertEquals(node3, node2.next);
        assertEquals(node1, node3.next);
    }

    @Test
    void testDeleteHead() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        csll.InsertHead(node1);
        csll.InsertHead(node2);
        csll.InsertHead(node3);

        csll.DeleteHead();

        assertEquals(2, csll.size);
        assertEquals(node2, csll.head);
        assertEquals(node1, csll.tail);
        assertEquals(node2, csll.tail.next);
    }

    @Test
    void testDeleteTail() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        csll.InsertHead(node1);
        csll.InsertHead(node2);
        csll.InsertHead(node3);

        csll.DeleteTail();

        assertEquals(2, csll.size);
        assertEquals(node3, csll.head);
        assertEquals(node2, csll.tail);
        assertEquals(node3, csll.tail.next);
    }

    @Test
    void testDelete() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        csll.InsertHead(node1);
        csll.InsertHead(node2);
        csll.InsertHead(node3);

        csll.Delete(node2);

        assertEquals(2, csll.size);
        assertEquals(node3, csll.head);
        assertEquals(node1, csll.tail);
        assertEquals(node1, node3.next);
    }

    @Test
    void testClear() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        csll.InsertHead(node1);
        csll.InsertHead(node2);
        csll.InsertHead(node3);

        csll.Clear();

        assertEquals(0, csll.size);
        assertNull(csll.head);
        assertNull(csll.tail);
    }

    @Test
    void testIsSorted() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        csll.InsertHead(node2);
        csll.InsertHead(node1);
        csll.InsertHead(node3);

        assertFalse(csll.isSorted());

        csll.Sort();

        assertTrue(csll.isSorted());
    }

    @Test
    void testSearch() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        csll.InsertHead(node1);
        csll.InsertHead(node2);
        csll.InsertHead(node3);

        assertEquals(node2, csll.Search(node2));
        assertNull(csll.Search(new SNode(4)));
    }
}
