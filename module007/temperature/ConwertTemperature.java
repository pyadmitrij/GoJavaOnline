package temperature;

public class ConwertTemperature {
	
	// ft - температура по Фарингейту
	// 32, 5/9 - это, наверное magic numbers
	public double convertToCelsius(double ft) {
		return (ft - 32) * 5/9;
	}
	
	// cel - температура по Цельсию
	// 9/5, 32 - это, наверное magic numbers
	public double convertToFahrenheit(double cel) {
		return (cel * 9/5) + 32;
	}

}
