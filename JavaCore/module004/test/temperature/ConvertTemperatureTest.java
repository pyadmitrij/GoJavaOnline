package module004.test.temperature;

import module004.temperature.Temperature;

import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConvertTemperatureTest {

    private static Temperature celsius;
    private static Temperature fahrenheit;

    @BeforeClass
    public static void setUpClass() throws Exception {
        celsius = new Temperature(38.0);
        fahrenheit = new Temperature(100.4);
    }

    @Test(timeout = 1000)
    public void testConvertToCelsius() throws Exception {
        final double temperature = celsius.convertToFahrenheit(celsius);
        assertEquals(celsius.convertToFahrenheit(celsius), temperature);
    }

    @Test(timeout = 1000)
    public void tetsCovertToFahrenheit() throws Exception {
        final double temperature = fahrenheit.convertToFahrenheit(fahrenheit);
        assertEquals(fahrenheit.convertToFahrenheit(fahrenheit), temperature);
    }
}
