package temperature;

public class Temperature {
	
	private double t;
	
	public double getT() {
		return t;
	}
	
	public Temperature(double t) {
		this.t = t;
	}

	public double covertToCelsius(Temperature far) {
		return (far.t - 32) * 5/9;
	}
	
	public double converToFahrenheit(Temperature cel) {
		return cel.t * 9/5 + 32;
	}

}
