package temperature;

public class MainTemperatur {
	
	public static void main (String... args) {
		Temperature celsius = new Temperature(38);
		Temperature fahringet = new Temperature(100.4);
		
		System.out.println("Celsius: " + celsius.getT() +" = Fahrenheit: " + celsius.converToFahrenheit(celsius));
		System.out.println("Fahrenheit: " + fahringet.getT() +" = Celsius: " + fahringet.covertToCelsius(fahringet));
	}

}
