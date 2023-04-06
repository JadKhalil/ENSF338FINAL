
package test.java.mylib.datastructures.trees;

import main.java.mylib.datastructures.nodes.TNode;
import main.java.mylib.datastructures.trees.BST;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BSTTest {
    private BST bst;

    @Before
    public void setUp() {
        bst = new BST();
    }

    @Test
    public void testInsertAndSearch() {
        bst.Insert(5);
        bst.Insert(3);
        bst.Insert(7);
        bst.Insert(2);
        bst.Insert(4);
        bst.Insert(6);
        bst.Insert(8);

        Assert.assertNotNull(bst.Search(5));
        Assert.assertNotNull(bst.Search(3));
        Assert.assertNotNull(bst.Search(7));
        Assert.assertNotNull(bst.Search(2));
        Assert.assertNotNull(bst.Search(4));
        Assert.assertNotNull(bst.Search(6));
        Assert.assertNotNull(bst.Search(8));

        Assert.assertNull(bst.Search(9));
        Assert.assertNull(bst.Search(1));
    }

    @Test
    public void testDelete() {
        bst.Insert(5);
        bst.Insert(3);
        bst.Insert(7);
        bst.Insert(2);
        bst.Insert(4);
        bst.Insert(6);
        bst.Insert(8);

        bst.Delete(3);
        Assert.assertNull(bst.Search(3));

        bst.Delete(5);
        Assert.assertNull(bst.Search(5));

        bst.Delete(7);
        Assert.assertNull(bst.Search(7));
    }

    @Test
    public void testHeight() {
        bst.Insert(5);
        bst.Insert(3);
        bst.Insert(7);
        bst.Insert(2);
        bst.Insert(4);
        bst.Insert(6);
        bst.Insert(8);

        TNode root = bst.getRoot();
        Assert.assertEquals(3, bst.height(root));
    }

    @Test
    public void testInsertDuplicate() {
        bst.Insert(5);
        bst.Insert(3);
        bst.Insert(3);
        bst.Insert(7);
        bst.Insert(7);

        TNode node3 = bst.Search(3);
        TNode node7 = bst.Search(7);
        Assert.assertNotNull(node3);
        Assert.assertNotNull(node7);
        Assert.assertNull(node3.getLeft());
        Assert.assertNull(node3.getRight());
        Assert.assertNull(node7.getLeft());
        Assert.assertNull(node7.getRight());
    }

    @Test
    public void testDeleteLeafNode() {
        bst.Insert(5);
        bst.Insert(3);
        bst.Insert(7);
        bst.Insert(2);
        bst.Insert(4);
        bst.Insert(6);
        bst.Insert(8);

        bst.Delete(2);
        Assert.assertNull(bst.Search(2));
        Assert.assertEquals(3, bst.getRoot().getLeft().getData());
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        bst.Insert(5);
        bst.Insert(3);
        bst.Insert(7);
        bst.Insert(2);
        bst.Insert(4);

        bst.Delete(3);
        Assert.assertNull(bst.Search(3));
        Assert.assertEquals(4, bst.getRoot().getLeft().getData());
        Assert.assertEquals(2, bst.getRoot().getLeft().getLeft().getData());
        Assert.assertNull(bst.getRoot().getLeft().getRight());
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        bst.Insert(5);
        bst.Insert(3);
        bst.Insert(7);
        bst.Insert(2);
        bst.Insert(4);
        bst.Insert(6);
        bst.Insert(8);

        bst.Delete(5);
        Assert.assertNull(bst.Search(5));
        Assert.assertEquals(6, bst.getRoot().getData());
    }
}
