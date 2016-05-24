import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseCalculatorTest {
    private static BaseCalculator example;
    @BeforeClass
    public static void setup() {
        example = new BaseCalculator();
    }

    @org.junit.Test
    public void testRead() throws Exception {
        example.read("6+7");
        System.out.println(example.getResult());
    }
}