package finalproject;

public class Main {

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.insert(9);
        tree.insert(6);
        tree.insert(16);
        tree.insert(4);
        tree.insert(7);
        tree.insert(10);
        tree.insert(19);


        System.out.println("inOrder:");
        tree.inOrder(tree.getRoot());

        System.out.println("\npreOrder:");
        tree.preOrder(tree.getRoot());

        System.out.println("\npostOrder:");
        tree.postOrder(tree.getRoot());
    }
}
