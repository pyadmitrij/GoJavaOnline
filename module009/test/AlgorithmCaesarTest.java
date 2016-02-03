package module009.test;

import module009.utillist.AlgorithmCaesar;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AlgorithmCaesarTest {

    private static AlgorithmCaesar algorithm;

    @BeforeClass
    public static void setUp() throws Exception {
        algorithm = new AlgorithmCaesar();
    }

    @Test(timeout = 1000)
    public void testEncode() throws Exception {
        final char key = 0;
        String string1 = "Hello, go to Java!!!";
        String string2 = algorithm.encode(string1, key);
        Assert.assertEquals(string2, algorithm.encode(string1, key));
    }

    @Test(timeout = 1000)
    public void testDecode() throws Exception {
        final char key = 0;
        String string1 = "Hello world!!!";
        String string2 = algorithm.encode(string1, key);
        Assert.assertEquals(string1, algorithm.decode(string2, key));
    }
}

