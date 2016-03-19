package module004.test.area;

import module004.figure.Circle;
import module004.figure.Figure;
import module004.figure.Rectangle;
import module004.figure.Triangle;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AreaTest {

    private static Figure circle;
    private static Figure triangle;
    private static Figure rectangle;

    @BeforeClass
    public static void setUp() throws Exception {
        circle = new Circle(2.5);
        triangle = new Triangle(3, 4);
        rectangle = new Rectangle(2, 2);
    }

    @Test(timeout = 1000)
    public void testAreaCircle() throws Exception {
        final double area = circle.area();
        assertEquals(area, circle.area());
    }

    @Test(timeout = 1000)
    public void testAreaTriangle() throws Exception {
        final double area = triangle.area();
        assertEquals(area, triangle.area());
    }

    @Test(timeout = 1000)
    public void testAreaRectangle() throws Exception {
        final double area = rectangle.area();
        assertEquals(area, rectangle.area());
    }
}