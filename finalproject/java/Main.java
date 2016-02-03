package finalproject.java;

import java.util.ArrayList;
import java.util.List;

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

        List<Integer> data = new ArrayList<>();

        System.out.println("inOrder:");
        tree.inOrder(tree.getRoot(), data);
        System.out.println(data.toString());
        data.clear();

        System.out.println("\npreOrder:");
        tree.preOrder(tree.getRoot(), data);
        System.out.println(data);
        data.clear();

        System.out.println("\npostOrder:");
        tree.postOrder(tree.getRoot(), data);
        System.out.println(data);
    }
}
