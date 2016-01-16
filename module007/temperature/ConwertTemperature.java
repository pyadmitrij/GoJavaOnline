package temperature;

public class ConwertTemperature {
	
	// ft - Температура по Фарингейту
	// 32, 5/9 - это, наверое magic numbers
	public double convertToCelsius(double ft) {
		return (ft - 32) * 5/9;
	}
	
	// cel - Температура по Цельсию
	// 9/5, 32 - это, наверное magic numbers
	public double convertToFahrenheit(double cel) {
		return (cel * 9/5) + 32;
	}

}
