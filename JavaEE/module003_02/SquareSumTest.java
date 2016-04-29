package module00302;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SquareSumTest {

    private static SquareSumOfArray ssoa;
    @Before
    public void setUp() throws Exception {
        ssoa = new SquareSumOfArray();
    }
    @Test
    public void testGetSquareSum() throws Exception {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        long actual = 385;
        long expected = ssoa.getSquareSum(arr, 3);

        assertEquals("Test number One: ",expected, actual);
    }
    @Test
    public void testGetSquareSumArrayNull() throws Exception {
        int[] arr = {};
        long actual = 0;
        long expected = ssoa.getSquareSum(arr, 3);

        assertEquals("Test number Two: ",expected, actual);
    }
}
