package module005.test;
import module005.array.MinMaxSort;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class MinMaxSortTest {

    private static MinMaxSort minMaxSort;
    private static int[] array;

    @BeforeClass
    public static void setUp() throws Exception {
        minMaxSort = new MinMaxSort();
        array = new int[] {10, 5, 6, 15, 20};
        System.out.println("@Before");
    }

    @Test(timeout = 1000)
    public void testFindMin() throws Exception {
        int min = 5;
        assertEquals(min, minMaxSort.findMin(array));
    }

    @Test(timeout = 1000)
    public void testFindMax() throws Exception {
        int max = 20;
        assertEquals(max, minMaxSort.findMax(array));
    }

    @Test(timeout = 1000)
    public void testSortSelect() throws Exception {
        int[] sortArray = new int[] {5, 6, 10, 15, 20};
        minMaxSort.sortSelect(array);
        String str1 = Arrays.toString(sortArray);
        String str2 = Arrays.toString(array);
        assertEquals(str1, str2);
    }
}
