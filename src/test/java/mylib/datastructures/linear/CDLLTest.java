
package test.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.linear.CDLL;
import main.java.mylib.datastructures.nodes.DNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CDLLTest {

    private CDLL cdll;

    @Before
    public void setUp() {
        cdll = new CDLL();
    }

    @Test
    public void testInsertHead() {
        cdll.InsertHead(new DNode(3));
        cdll.InsertHead(new DNode(2));
        cdll.InsertHead(new DNode(1));

        cdll.Print();

        Assert.assertEquals(3, cdll.size);
        Assert.assertEquals(1, cdll.head.data);
        Assert.assertEquals(2, cdll.head.next.data);
        Assert.assertEquals(3, cdll.tail.data);
    }

    @Test
    public void testInsertTail() {
        cdll.InsertTail(new DNode(1));
        cdll.InsertTail(new DNode(2));
        cdll.InsertTail(new DNode(3));

        cdll.Print();

        Assert.assertEquals(3, cdll.size);
        Assert.assertEquals(1, cdll.head.data);
        Assert.assertEquals(2, cdll.head.next.data);
        Assert.assertEquals(3, cdll.tail.data);
    }

    @Test
    public void testInsert() {
        cdll.InsertHead(new DNode(1));
        cdll.InsertTail(new DNode(3));
        cdll.Insert(new DNode(2), 1);

        cdll.Print();

        Assert.assertEquals(3, cdll.size);
        Assert.assertEquals(1, cdll.head.data);
        Assert.assertEquals(2, cdll.head.next.data);
        Assert.assertEquals(3, cdll.tail.data);
    }

    @Test
    public void testDeleteHead() {
        cdll.InsertHead(new DNode(3));
        cdll.InsertHead(new DNode(2));
        cdll.InsertHead(new DNode(1));
        cdll.DeleteHead();

        cdll.Print();

        Assert.assertEquals(2, cdll.size);
        Assert.assertEquals(2, cdll.head.data);
        Assert.assertEquals(3, cdll.tail.data);
    }

    @Test
    public void testDeleteTail() {
        cdll.InsertHead(new DNode(3));
        cdll.InsertHead(new DNode(2));
        cdll.InsertHead(new DNode(1));
        cdll.DeleteTail();

        cdll.Print();

        Assert.assertEquals(2, cdll.size);
        Assert.assertEquals(1, cdll.head.data);
        Assert.assertEquals(2, cdll.tail.data);
    }

    @Test
    public void testDelete() {
        cdll.InsertHead(new DNode(3));
        cdll.InsertHead(new DNode(2));
        cdll.InsertHead(new DNode(1));
        cdll.Delete(cdll.head.next);

        cdll.Print();

        Assert.assertEquals(2, cdll.size);
        Assert.assertEquals(1, cdll.head.data);
        Assert.assertEquals(3, cdll.tail.data);
    }

    @Test
    public void testSearch() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        cdll.InsertHead(node1);
        cdll.InsertHead(node2);
        cdll.InsertHead(node3);

        Assert.assertEquals(node1, cdll.Search(node1));
        Assert.assertEquals(node2, cdll.Search(node2));
        Assert.assertEquals(node3, cdll.Search(node3));
    }

    @Test
    public void testIsSorted() {
        cdll.InsertHead(new DNode(3));
        cdll.InsertHead(new DNode(2));
        cdll.InsertHead(new DNode(1));

        Assert.assertTrue(cdll.isSorted());

        cdll.InsertTail(new DNode(0));

        Assert.assertFalse(cdll.isSorted());
    }

    @Test
    public void testSort() {
        cdll.InsertHead(new DNode(2));
        cdll.InsertHead(new DNode(1));
        cdll.InsertHead(new DNode(3));

        cdll.Sort();

        Assert.assertTrue(cdll.isSorted());
    }

    @Test
    public void testSortedInsert() {
        cdll.InsertHead(new DNode(3));
        cdll.InsertHead(new DNode(1));

        cdll.SortedInsert(new DNode(2));

        cdll.Print();

        Assert.assertEquals(3, cdll.size);
        Assert.assertEquals(1, cdll.head.data);
        Assert.assertEquals(2, cdll.head.next.data);
        Assert.assertEquals(3, cdll.tail.data);
    }

    @Test
    public void testClear() {
        cdll.InsertHead(new DNode(1));
        cdll.InsertHead(new DNode(2));
        cdll.InsertHead(new DNode(3));

        cdll.Clear();

        Assert.assertEquals(0, cdll.size);
        Assert.assertNull(cdll.head);
        Assert.assertNull(cdll.tail);
    }
}
