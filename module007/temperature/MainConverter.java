package temperature;

public class MainConverter {
	
	public static void main (String... args) {
		ConwertTemperature ct = new ConwertTemperature();
		
		System.out.println("Tempheratute Celsius : " + ct.convertToCelsius(33.8));
		System.out.println("Tempheratute Fahrenheit : " + ct.convertToFahrenheit(1));
	}
}
