package finalproject.java;

import java.util.List;

public class Tree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public Tree() {
        this.root = null;
    }

    public void insert(int data) {
        root = insert(root, data, null);
    }

    private Node insert(Node current, int data, Node parent) {
        if(current == null) {
            current = new Node();
            current.setData(data);
            current.setLeft(null);
            current.setRight(null);
            current.setParent(parent);
        }
        else if(data < current.getData())
            current.setLeft(insert(current.getLeft(), data, current));
        else
            current.setRight(insert(current.getRight(), data, current));
        return current;
    }

    public void inOrder(Node root, List<Integer> data) {
        if(root != null) {
            inOrder(root.getLeft(), data);
            data.add(root.getData());
            inOrder(root.getRight(), data);
        }
    }

    public void preOrder(Node root, List<Integer> data) {
        if(root != null) {
            data.add(root.getData());
            preOrder(root.getLeft(), data);
            preOrder(root.getRight(), data);
        }
    }

    public void postOrder(Node root, List<Integer> data) {
        if (root == null)
            return;
        if (root.getLeft() == null && root.getRight() == null)
            data.add(root.getData());
        else {
            postOrder(root.getLeft(), data);
            postOrder(root.getRight(), data);
            data.add(root.getData());
        }
    }
}