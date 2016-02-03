package finalproject.test;

import finalproject.java.Tree;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {

    private static Tree tree;
    private List<Integer> data = new ArrayList<>();

    @BeforeClass
    public static void setUp() throws Exception {
        tree = new Tree();
        tree.insert(9);
        tree.insert(6);
        tree.insert(16);
        tree.insert(4);
        tree.insert(7);
        tree.insert(10);
        tree.insert(19);
    }

    @Test(timeout = 1000)
    public void testInOrder() throws Exception {
        tree.inOrder(tree.getRoot(), data);
        String string = "[4, 6, 7, 9, 10, 16, 19]";
        Assert.assertEquals(string, data.toString());
    }

    @Test(timeout = 1000)
    public void testPreOrder() throws Exception {
        tree.preOrder(tree.getRoot(), data);
        String string = "[9, 6, 4, 7, 16, 10, 19]";
        Assert.assertEquals(string, data.toString());
    }

    @Test(timeout = 1000)
    public void testPostOrder() throws Exception {
        tree.postOrder(tree.getRoot(), data);
        String string = "[4, 7, 6, 10, 19, 16, 9]";
        Assert.assertEquals(string, data.toString());
    }
}
