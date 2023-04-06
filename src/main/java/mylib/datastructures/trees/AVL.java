
// AVL tree

package main.java.mylib.datastructures.trees;

import main.java.mylib.datastructures.nodes.TNode;

public class AVL extends BST {

    public AVL() {
        super();
    }

    public AVL(int val) {
        super(val);
    }

    public AVL(TNode obj) {
        setRoot(obj);
    }

    public void setRoot(TNode root) {
        this.root = root;
        super.height(this.root);
        if (this.root.getLeft() != null || this.root.getRight() != null) {
            // this.root = BalanceAVL(root); // this must be modified
            setRootRec(this.root);
            // we must recursivly bottom out
            // then as we pop the call sacks we check the balance of each node
            // and balance accordingly
        }
    }

    private void setRootRec(TNode root) {
        if (root != null) {
            setRootRec(root.getLeft());
            setRootRec(root.getRight());
            // once we have reached maximum depth we check the balance and if the node is
            // unblanced we call BalanceAVL
            if (root.getBalance() > 1 || root.getBalance() < -1) {

                TNode parent = root.getParent();
                TNode balanced = BalanceAVL(root);
                if (parent != null) {

                    if (parent.getLeft() == root) {
                        parent.setLeft(balanced);
                    } else {
                        parent.setRight(balanced);
                    }
                    balanced.setParent(parent);
                    // root = balanced;
                } else {
                    this.root = balanced;
                }

                super.height(this.root);
                System.out.println("After one rotation " + root.getData() + ":");
                printBF();

                // make another helper function that resets the parents in the tree
            }
        }
    }

    private TNode BalanceAVL(TNode root) {
        int balance = root.getBalance();

        if (balance > 1) {
            if (super.height(root.getRight().getRight()) > super.height(root.getRight().getLeft())) {
                root = rotateLeft(root);
            } else {
                root.setRight(rotateRight(root.getRight()));
                root = rotateLeft(root);
            }
        } else if (balance < -1) {
            if (super.height(root.getLeft().getLeft()) > super.height(root.getLeft().getRight())) {
                System.out.println("here!");
                root = rotateRight(root);
            } else {
                System.out.println("over der!");
                root.setLeft(rotateLeft(root.getLeft()));
                root = rotateRight(root);
            }
        }

        return root;
    }

    private TNode rotateRight(TNode node) {
        TNode x = node.getLeft();
        TNode z = x.getRight();
        x.setRight(node);
        node.setLeft(z);

        node.setParent(x);
        if (z != null)
            z.setParent(node);
        super.height(this.root);
        return x;
    }

    private TNode rotateLeft(TNode node) {
        TNode x = node.getRight();
        TNode z = x.getLeft();
        x.setLeft(node);
        node.setRight(z);

        node.setParent(x);
        if (z != null)
            z.setParent(node);

        super.height(this.root);
        return x;
    }

    public TNode getRoot() {
        return this.root;
    }

    public void Insert(int val) {
        TNode node = new TNode(val, 0, null, null, null);
        setRoot(InsertRec(this.root, node));

    }

    public void Insert(TNode node) {
        setRoot(InsertRec(this.root, node));
    }

    private TNode InsertRec(TNode root, TNode node) {
        if (root == null)
            return node;
        else if (root.getData() > node.getData()) {

            TNode leftChild = InsertRec(root.getLeft(), node);
            root.setLeft(leftChild);
            leftChild.setParent(root);

        } else if (root.getData() < node.getData()) {
            TNode rightChild = InsertRec(root.getRight(), node);
            root.setRight(rightChild);
            rightChild.setParent(root);
        } else
            System.out.println("Duplicte key");

        return BalanceAVL(root);
    }

    public void Delete(int val) {

        TNode found = Search(val);

        if (found == null) {
            System.out.println("Cannot find node to delete");
        } else {
            this.root = DeleteRec(this.root, val);
            height(this.root);
        }
    }

    private TNode DeleteRec(TNode root, int val) {
        if (root == null)
            return root;

        if (val < root.getData()) {
            TNode result = DeleteRec(root.getLeft(), val);
            root.setLeft(result);
        }

        else if (val > root.getData()) {
            TNode result = DeleteRec(root.getRight(), val);
            root.setRight(result);
        } else {
            if (root.getLeft() == null)
                return root.getRight();
            else if (root.getRight() == null)
                return root.getLeft();

            root.setData(minValue(root.getRight()));

            TNode inOrderDel = DeleteRec(root.getRight(), root.getData());
            root.setRight(inOrderDel);
        }

        if (root != null)
            root = BalanceAVL(root);

        return root;
    }

    @Override
    public TNode Search(int val) {
        return super.Search(val);
    }

    @Override
    public void printInOrder() {
        super.printInOrder();
    }

    @Override
    public void printBF() {
        super.printBF();
    }
}
