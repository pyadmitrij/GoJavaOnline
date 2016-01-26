package temperature;

public class ConwertTemperature {
	
	// ft - Temperature Fahrenheit
	// 32, 5/9 - this is magic numbers
	public double convertToCelsius(double ft) {
		return (ft - 32) * 5/9;
	}
	
	// cel - Temperature Celsius
	// 9/5, 32 - this is magic numbers
	public double convertToFahrenheit(double cel) {
		return (cel * 9/5) + 32;
	}

}
