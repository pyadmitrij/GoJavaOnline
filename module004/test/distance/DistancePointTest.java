package module004.test.distance;

import module004.distance.Point;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DistancePointTest {

    private Point pointA;
    private Point pointB;

    @Before
    public void setUp() throws Exception {
        pointA = new Point(0, 0);
        pointB = new Point(2, 2);
    }
    @Test (timeout = 1000)
    public void testDistance() throws Exception {
        final double result = pointA.distance(pointB);
        assertEquals(pointA.distance(pointB), result);
    }
}
