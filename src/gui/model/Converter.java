package gui.model;

public class Converter {

	private static Double rate = 4.8839;
	
	public static Double conversion(Double value) {
		Double newValue = value * rate;
		return newValue;
	}
}