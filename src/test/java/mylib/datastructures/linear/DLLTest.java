
package test.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;
import main.java.mylib.datastructures.linear.DLL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DLLTest {
    private DLL dll;

    @BeforeEach
    void setUp() {
        dll = new DLL();
    }

    @Test
    void testInsertHead() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        dll.InsertHead(node1);
        assertEquals(1, dll.size);
        assertEquals(node1, dll.head);
        assertEquals(node1, dll.tail);

        dll.InsertHead(node2);
        assertEquals(2, dll.size);
        assertEquals(node2, dll.head);
        assertEquals(node1, dll.tail);
        assertEquals(node1, node2.next);
        assertNull(node2.prev);
    }

    @Test
    void testInsertTail() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        dll.InsertTail(node1);
        assertEquals(1, dll.size);
        assertEquals(node1, dll.head);
        assertEquals(node1, dll.tail);

        dll.InsertTail(node2);
        assertEquals(2, dll.size);
        assertEquals(node1, dll.head);
        assertEquals(node2, dll.tail);
        assertEquals(node2, node1.next);
        assertNull(node1.prev);
    }

    @Test
    void testInsert() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.Insert(node1, 0);
        dll.Insert(node2, 1);
        dll.Insert(node3, 1);

        assertEquals(3, dll.size);
        assertEquals(node1, dll.head);
        assertEquals(node2, dll.tail);
        assertEquals(node3, node1.next);
        assertEquals(node2, node3.next);
    }

    @Test
    void testDeleteHead() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        dll.InsertHead(node1);
        dll.InsertHead(node2);

        dll.DeleteHead();
        assertEquals(1, dll.size);
        assertEquals(node1, dll.head);
        assertEquals(node1, dll.tail);

        dll.DeleteHead();
        assertEquals(0, dll.size);
        assertNull(dll.head);
        assertNull(dll.tail);
    }

    @Test
    void testDeleteTail() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        dll.InsertTail(node1);
        dll.InsertTail(node2);

        dll.DeleteTail();
        assertEquals(1, dll.size);
        assertEquals(node1, dll.head);
        assertEquals(node1, dll.tail);

        dll.DeleteTail();
        assertEquals(0, dll.size);
        assertNull(dll.head);
        assertNull(dll.tail);
    }

    @Test
    void testDelete() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.InsertHead(node3);

        dll.Delete(node2);
        assertEquals(2, dll.size);
        assertEquals(node3, dll.head);
        assertEquals(node1, dll.tail);
        assertEquals(node1, node3.next);
        assertNull(node1.next);
        assertNull(node3.prev);
    }


    @Test
    void testSort() {
        DNode node1 = new DNode(3);
        DNode node2 = new DNode(1);
        DNode node3 = new DNode(2);

        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.InsertHead(node3);

        dll.Sort();
        assertEquals(3, dll.size);
        assertEquals(node2, dll.head);
        assertEquals(node1, dll.tail);
        assertEquals(node3, node2.next);
        assertEquals(node1, node3.next);
        assertNull(node2.prev);
    }

    @Test
    void testSortedInsert() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.InsertHead(node2);
        dll.InsertHead(node1);
        dll.SortedInsert(node3);

        assertEquals(3, dll.size);
        assertEquals(node1, dll.head);
        assertEquals(node1, node2.prev);
        assertEquals(node1, node3.prev.prev);
        assertEquals(node2, node1.next);
        assertEquals(node2, node3.prev);
        assertEquals(node3, dll.tail);
        assertEquals(node3, node2.next);
        assertEquals(node3, node1.next.next);
        assertNull(node1.prev);
        assertNull(node3.next);
    }

    @Test
    void testIsSorted() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.InsertHead(node3);

        assertFalse(dll.isSorted());

        dll.Sort();
        assertTrue(dll.isSorted());
    }

    @Test
    void testSearch() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.InsertHead(node3);

        assertEquals(node1, dll.Search(node1));
        assertEquals(node2, dll.Search(node2));
        assertEquals(node3, dll.Search(node3));
        assertNull(dll.Search(new DNode(4)));
    }

    @Test
    void testClear() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.InsertHead(node1);
        dll.InsertHead(node2);
        dll.InsertHead(node3);

        dll.Clear();
        assertEquals(0, dll.size);
        assertNull(dll.head);
        assertNull(dll.tail);
    }
}
