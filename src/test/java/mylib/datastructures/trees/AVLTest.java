
package test.java.mylib.datastructures.trees;

import main.java.mylib.datastructures.trees.AVL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AVLTest {

    private AVL avl;

    @Before
    public void setUp() {
        avl = new AVL();
    }

    @Test
    public void testInsertion() {
        avl.Insert(5);
        avl.Insert(3);
        avl.Insert(7);
        avl.Insert(2);
        avl.Insert(4);
        avl.Insert(6);
        avl.Insert(8);
        avl.Insert(1);
        avl.Insert(9);

        Assert.assertNotNull(avl.Search(1));
        Assert.assertNotNull(avl.Search(9));
    }

    @Test
    public void testDeletion() {
        avl.Insert(5);
        avl.Insert(3);
        avl.Insert(7);
        avl.Insert(2);
        avl.Insert(4);
        avl.Insert(6);
        avl.Insert(8);
        avl.Insert(1);
        avl.Insert(9);

        avl.Delete(1);
        avl.Delete(9);

        Assert.assertNull(avl.Search(1));
        Assert.assertNull(avl.Search(9));
    }

    @Test
    public void testRightRotation() {
        avl.Insert(5);
        avl.Insert(3);
        avl.Insert(2);
        avl.Insert(1);

        Assert.assertEquals(3, avl.getRoot().getData());
        Assert.assertEquals(2, avl.getRoot().getLeft().getData());
        Assert.assertEquals(1, avl.getRoot().getLeft().getLeft().getData());
        Assert.assertEquals(5, avl.getRoot().getRight().getData());
    }

    @Test
    public void testLeftRotation() {
        avl.Insert(1);
        avl.Insert(2);
        avl.Insert(3);
        avl.Insert(4);

        Assert.assertEquals(2, avl.getRoot().getData());
        Assert.assertEquals(1, avl.getRoot().getLeft().getData());
        Assert.assertEquals(3, avl.getRoot().getRight().getData());
        Assert.assertEquals(4, avl.getRoot().getRight().getRight().getData());
    }

    @Test
    public void testLeftRightRotation() {
        avl.Insert(5);
        avl.Insert(2);
        avl.Insert(3);

        Assert.assertEquals(3, avl.getRoot().getData());
        Assert.assertEquals(2, avl.getRoot().getLeft().getData());
        Assert.assertEquals(5, avl.getRoot().getRight().getData());
    }

    @Test
    public void testRightLeftRotation() {
        avl.Insert(1);
        avl.Insert(3);
        avl.Insert(2);

        Assert.assertEquals(2, avl.getRoot().getData());
        Assert.assertEquals(1, avl.getRoot().getLeft().getData());
        Assert.assertEquals(3, avl.getRoot().getRight().getData());
    }

    ///////////////////
    /////////////////// Edge cases
    ///////////////////

    @Test
    public void testInsertDescendingOrder() {
        AVL avl = new AVL(9);
        avl.Insert(8);
        avl.Insert(7);
        avl.Insert(6);
        avl.Insert(5);

        Assert.assertTrue(Math.abs(avl.getRoot().getBalance()) <= 1);

        Assert.assertEquals(8, avl.getRoot().getData());
        Assert.assertEquals(6, avl.getRoot().getLeft().getData());
        Assert.assertEquals(9, avl.getRoot().getRight().getData());
        Assert.assertEquals(7, avl.getRoot().getLeft().getRight().getData());
        Assert.assertEquals(5, avl.getRoot().getLeft().getLeft().getData());
    }

    @Test
    public void testInsertAscendingOrder() {
        AVL avl = new AVL(5);
        avl.Insert(6);
        avl.Insert(7);
        avl.Insert(8);
        avl.Insert(9);

        Assert.assertTrue(Math.abs(avl.getRoot().getBalance()) <= 1);

        Assert.assertEquals(6, avl.getRoot().getData());
        Assert.assertEquals(5, avl.getRoot().getLeft().getData());
        Assert.assertEquals(8, avl.getRoot().getRight().getData());
        Assert.assertEquals(7, avl.getRoot().getRight().getLeft().getData());
        Assert.assertEquals(9, avl.getRoot().getRight().getRight().getData());
        Assert.assertNull(avl.getRoot().getLeft().getRight());
        Assert.assertNull(avl.getRoot().getLeft().getLeft());
    }

    @Test
    public void testInsertRandomElements() {
        AVL avl = new AVL(50);
        avl.Insert(30);
        avl.Insert(20);
        avl.Insert(40);
        avl.Insert(70);
        avl.Insert(60);
        avl.Insert(80);

        Assert.assertTrue(Math.abs(avl.getRoot().getBalance()) <= 1);

        Assert.assertEquals(50, avl.getRoot().getData());
        Assert.assertEquals(30, avl.getRoot().getLeft().getData());
        Assert.assertEquals(20, avl.getRoot().getLeft().getLeft().getData());
        Assert.assertEquals(40, avl.getRoot().getLeft().getRight().getData());
        Assert.assertEquals(70, avl.getRoot().getRight().getData());
        Assert.assertEquals(60, avl.getRoot().getRight().getLeft().getData());
        Assert.assertEquals(80, avl.getRoot().getRight().getRight().getData());
    }

    @Test
    public void testDuplicateInsertion() {
        AVL avl = new AVL();
        avl.Insert(5);
        avl.Insert(3);
        avl.Insert(7);
        avl.Insert(5);

        Assert.assertNull(avl.Search(4));
        Assert.assertEquals(5, avl.getRoot().getData());
        Assert.assertEquals(3, avl.getRoot().getLeft().getData());
        Assert.assertEquals(7, avl.getRoot().getRight().getData());
    }

    @Test
    public void testMultipleDeletionsMaintainBalance() {
        AVL avl = new AVL();
        avl.Insert(9);
        avl.Insert(5);
        avl.Insert(10);
        avl.Insert(0);
        avl.Insert(6);
        avl.Insert(11);
        avl.Insert(4);
        avl.Insert(1);
        avl.Insert(2);

        avl.Delete(10);
        avl.Delete(11);

        Assert.assertTrue(Math.abs(avl.getRoot().getBalance()) <= 1);

        Assert.assertEquals(4, avl.getRoot().getData());
        Assert.assertEquals(1, avl.getRoot().getLeft().getData());
        Assert.assertEquals(6, avl.getRoot().getRight().getData());
        Assert.assertEquals(0, avl.getRoot().getLeft().getLeft().getData());
        Assert.assertEquals(2, avl.getRoot().getLeft().getRight().getData());
        Assert.assertEquals(5, avl.getRoot().getRight().getLeft().getData());
        Assert.assertEquals(9, avl.getRoot().getRight().getRight().getData());

        Assert.assertEquals(4, avl.getRoot().getLeft().getParent().getData());
        Assert.assertEquals(4, avl.getRoot().getRight().getParent().getData());
        Assert.assertEquals(1, avl.getRoot().getLeft().getLeft().getParent().getData());
        Assert.assertEquals(1, avl.getRoot().getLeft().getRight().getParent().getData());
        Assert.assertEquals(6, avl.getRoot().getRight().getLeft().getParent().getData());
        Assert.assertEquals(6, avl.getRoot().getRight().getRight().getParent().getData());

        Assert.assertNull(avl.getRoot().getParent());
        Assert.assertNull(avl.getRoot().getLeft().getLeft().getLeft());
        Assert.assertNull(avl.getRoot().getLeft().getLeft().getRight());
        Assert.assertNull(avl.getRoot().getLeft().getRight().getLeft());
        Assert.assertNull(avl.getRoot().getLeft().getRight().getRight());
        Assert.assertNull(avl.getRoot().getRight().getLeft().getLeft());
        Assert.assertNull(avl.getRoot().getRight().getLeft().getRight());
        Assert.assertNull(avl.getRoot().getRight().getRight().getLeft());
        Assert.assertNull(avl.getRoot().getRight().getRight().getRight());
    }

    @Test
    public void testMultipleInsertionsMaintainBalance() {
        AVL avl = new AVL();
        avl.Insert(10);
        avl.Insert(20);
        avl.Insert(30);
        avl.Insert(40);
        avl.Insert(50);
        avl.Insert(25);

        Assert.assertEquals(30, avl.getRoot().getData());
        Assert.assertEquals(20, avl.getRoot().getLeft().getData());
        Assert.assertEquals(40, avl.getRoot().getRight().getData());
    }

    @Test
    public void testParentsWithDeletion() {
        AVL avl = new AVL();
        avl.Insert(7);
        avl.Insert(25);
        avl.Insert(13);
        avl.Insert(14);
        avl.Insert(78);
        avl.Insert(69);
        avl.Insert(36);
        avl.Insert(100);

        avl.Delete(7);
        avl.Delete(13);

        Assert.assertTrue(Math.abs(avl.getRoot().getBalance()) <= 1);

        Assert.assertNull(avl.getRoot().getParent());
        Assert.assertEquals(69, avl.getRoot().getLeft().getParent().getData());
        Assert.assertEquals(69, avl.getRoot().getRight().getParent().getData());
        Assert.assertEquals(25, avl.getRoot().getLeft().getLeft().getParent().getData());
        Assert.assertEquals(25, avl.getRoot().getLeft().getRight().getParent().getData());
        Assert.assertEquals(78, avl.getRoot().getRight().getRight().getParent().getData());
    }

    @Test
    public void testParentsWithOutDeletion() {
        AVL avl = new AVL();
        avl.Insert(26);
        avl.Insert(35);
        avl.Insert(87);
        avl.Insert(22);
        avl.Insert(65);
        avl.Insert(30);
        avl.Insert(4);


        Assert.assertTrue(Math.abs(avl.getRoot().getBalance()) <= 1);

        Assert.assertNull(avl.getRoot().getParent());
        Assert.assertEquals(35, avl.getRoot().getLeft().getParent().getData());
        Assert.assertEquals(35, avl.getRoot().getRight().getParent().getData());
        Assert.assertEquals(26, avl.getRoot().getLeft().getLeft().getParent().getData());
        Assert.assertEquals(26, avl.getRoot().getLeft().getRight().getParent().getData());
        Assert.assertEquals(87, avl.getRoot().getRight().getLeft().getParent().getData());
        Assert.assertEquals(22, avl.getRoot().getLeft().getLeft().getLeft().getParent().getData());
    }
}
