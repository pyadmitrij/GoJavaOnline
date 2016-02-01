package module004.temperature;

public class MainTemperatur {
	
	public static void main (String... args) {
		Temperature celsius = new Temperature(38);
		Temperature fahrenheit = new Temperature(100.4);
		
		System.out.println("Celsius: " + celsius.getTemperature() +" = Fahrenheit: " + celsius.convertToFahrenheit(celsius));
		System.out.println("Fahrenheit: " + fahrenheit.getTemperature() +" = Celsius: " + fahrenheit.covertToCelsius(fahrenheit));
	}

}
