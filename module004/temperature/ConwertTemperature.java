package temperature;

public class ConwertTemperature {
	
	public double convertToCelsius(double ft) {
		return (ft - 32) * 5/9;
	}
	
	public double convertToFahrenheit(double cel) {
		return (cel * 9/5) + 32;
	}

}
