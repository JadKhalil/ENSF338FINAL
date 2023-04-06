
package test.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.linear.StackLL;
import main.java.mylib.datastructures.nodes.SNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackLLTest {
    private StackLL stackLL;

    @Before
    public void setUp() {
        stackLL = new StackLL();
    }

    @Test
    public void testConstructorNoNode() {
        StackLL stackLLNoNode = new StackLL();

        Assert.assertEquals(0, stackLLNoNode.size);
        Assert.assertNull(stackLLNoNode.head);
    }

    @Test
    public void testConstructorSingleNode() {
        SNode node = new SNode(1);
        StackLL stackLLSingleNode = new StackLL(node);

        Assert.assertEquals(1, stackLLSingleNode.size);
        Assert.assertEquals(node, stackLLSingleNode.head);
    }

    @Test
    public void testPush() {
        stackLL.push(new SNode(1));
        stackLL.push(new SNode(2));
        stackLL.push(new SNode(3));

        Assert.assertEquals(3, stackLL.size);
        Assert.assertEquals(3, stackLL.head.data);
    }

    @Test
    public void testPop() {
        stackLL.push(new SNode(1));
        stackLL.push(new SNode(2));
        stackLL.push(new SNode(3));

        stackLL.pop();

        Assert.assertEquals(2, stackLL.size);
        Assert.assertEquals(2, stackLL.head.data);

        stackLL.pop();

        Assert.assertEquals(1, stackLL.size);
        Assert.assertEquals(1, stackLL.head.data);
    }

    @Test
    public void testPeek() {
        stackLL.push(new SNode(1));
        stackLL.push(new SNode(2));
        stackLL.push(new SNode(3));

        stackLL.peek();

        Assert.assertEquals(3, stackLL.size);
        Assert.assertEquals(3, stackLL.head.data);
    }

    @Test
    public void testClear() {
        stackLL.push(new SNode(1));
        stackLL.push(new SNode(2));
        stackLL.push(new SNode(3));

        stackLL.Clear();

        Assert.assertEquals(0, stackLL.size);
        Assert.assertNull(stackLL.head);
    }

    @Test
    public void testOverriddenMethods() {
        stackLL.push(new SNode(1));
        stackLL.push(new SNode(2));
        stackLL.push(new SNode(3));

        stackLL.DeleteTail();
        Assert.assertEquals(3, stackLL.size);

        stackLL.Delete(new SNode(2));
        Assert.assertEquals(3, stackLL.size);

        stackLL.InsertTail(new SNode(4));
        Assert.assertEquals(3, stackLL.size);

        stackLL.Insert(new SNode(5), 1);
        Assert.assertEquals(3, stackLL.size);

        stackLL.SortedInsert(new SNode(6));
        Assert.assertEquals(3, stackLL.size);

        Assert.assertNull(stackLL.Search(new SNode(1)));

        stackLL.Sort();
        Assert.assertEquals(3, stackLL.size);
    }
}
