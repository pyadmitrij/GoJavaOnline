package module004.temperature;

public class Temperature {
	
	private double temperature;
	
	public double getTemperature() {
		return temperature;
	}
	
	public Temperature(double temperature) {
		this.temperature = temperature;
	}

	public double covertToCelsius(Temperature fahrenheit) {
		return (fahrenheit.temperature - 32) * 5/9;
	}
	
	public double convertToFahrenheit(Temperature celsius) {
		return celsius.temperature * 9/5 + 32;
	}

}
