package finalproject;

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

    public void inOrder(Node root) {
        if(root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getData() + ", ");
            inOrder(root.getRight());
        }
    }

    public void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.getData() + ", ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public void postOrder(Node root) {
        if (root == null)
            return;
        if (root.getLeft() == null && root.getRight() == null)
            System.out.print(root.getData() + ", ");
        else {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getData() + ", ");
        }
    }
}