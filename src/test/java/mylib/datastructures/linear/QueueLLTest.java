
package test.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.linear.QueueLL;
import main.java.mylib.datastructures.nodes.SNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueLLTest {
    private QueueLL queueLL;

    @Before
    public void setUp() {
        queueLL = new QueueLL();
    }

    @Test
    public void testConstructorNoNode() {
        QueueLL queueLLNoNode = new QueueLL();

        Assert.assertEquals(0, queueLLNoNode.size);
        Assert.assertNull(queueLLNoNode.head);
    }

    @Test
    public void testConstructorSingleNode() {
        SNode node = new SNode(1);
        QueueLL queueLLSingleNode = new QueueLL(node);

        Assert.assertEquals(1, queueLLSingleNode.size);
        Assert.assertEquals(node, queueLLSingleNode.head);
    }

    @Test
    public void testEnqueue() {
        queueLL.enqueue(new SNode(1));
        queueLL.enqueue(new SNode(2));
        queueLL.enqueue(new SNode(3));

        Assert.assertEquals(3, queueLL.size);
        Assert.assertEquals(1, queueLL.head.data);
    }

    @Test
    public void testDequeue() {
        queueLL.enqueue(new SNode(1));
        queueLL.enqueue(new SNode(2));
        queueLL.enqueue(new SNode(3));

        queueLL.dequeue();

        Assert.assertEquals(2, queueLL.size);
        Assert.assertEquals(2, queueLL.head.data);
    }

    @Test
    public void testFront() {
        queueLL.enqueue(new SNode(1));
        queueLL.enqueue(new SNode(2));
        queueLL.enqueue(new SNode(3));

        queueLL.front();

        Assert.assertEquals(3, queueLL.size);
        Assert.assertEquals(1, queueLL.head.data);
    }

    @Test
    public void testClear() {
        queueLL.enqueue(new SNode(1));
        queueLL.enqueue(new SNode(2));
        queueLL.enqueue(new SNode(3));

        queueLL.Clear();

        Assert.assertEquals(0, queueLL.size);
        Assert.assertNull(queueLL.head);
    }

    @Test
    public void testOverriddenMethods() {
        queueLL.enqueue(new SNode(1));
        queueLL.enqueue(new SNode(2));
        queueLL.enqueue(new SNode(3));

        queueLL.DeleteTail();
        Assert.assertEquals(3, queueLL.size);

        queueLL.Delete(new SNode(2));
        Assert.assertEquals(3, queueLL.size);

        queueLL.InsertHead(new SNode(4));
        Assert.assertEquals(3, queueLL.size);

        queueLL.Insert(new SNode(5), 1);
        Assert.assertEquals(3, queueLL.size);

        queueLL.SortedInsert(new SNode(6));
        Assert.assertEquals(3, queueLL.size);

        Assert.assertNull(queueLL.Search(new SNode(1)));

        queueLL.Sort();
        Assert.assertEquals(3, queueLL.size);
    }
}
