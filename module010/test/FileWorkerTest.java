package module010.test;

import module010.utillist.AlgorithmCaesar;
import module010.utillist.FileWorker;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileWorkerTest {

    private static FileWorker worker;
    private static AlgorithmCaesar algorithm;
    private final String fileName = "text.txt";
    private final char key = 0;

    @BeforeClass
    public static void setUp() throws Exception {
        worker = new FileWorker();
        algorithm = new AlgorithmCaesar();
    }

    @Test(timeout = 1000)
    public void testWriteFile() throws Exception {
        String string1 = "I love JAVA!!!";
        string1 = algorithm.encode(string1, key);
        worker.writeFile(fileName, string1);
        String string2 = worker.readFile(fileName);
        Assert.assertEquals(string1, string2);
    }

    @Test(timeout = 1000)
    public void testReadFile() throws Exception {
        String string1 = "I love JAVA!!!";;
        String string2 = worker.readFile(fileName);
        string2 = algorithm.decode(string2, key);
        Assert.assertEquals(string1, string2);
    }
}
