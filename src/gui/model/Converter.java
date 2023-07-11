package gui.model;

public class Converter {

	private static Double rateUSDToBRL = 4.9003;
	private static Double rateUSDToEUR = 0.9100;
	private static Double rateEURToBRL = 5.3827;
	private static Double rateEURToUSD = 1.0988;
	private static Double rateBRLToUSD = 0.2041;
	private static Double rateBRLToEUR = 0.1857;
	
	public static Double conversion(String currency1, String currency2, Double value) {
		if(currency1 == "USD" && currency2 == "BRL") {
			Double newValue = value * rateUSDToBRL;
			return newValue;
		}
		if(currency1 == "USD" && currency2 == "EUR") {
			Double newValue = value * rateUSDToEUR;
			return newValue;
		}
		if(currency1 == "EUR" && currency2 == "BRL") {
			Double newValue = value * rateEURToBRL;
			return newValue;
		}
		if(currency1 == "EUR" && currency2 == "USD") {
			Double newValue = value * rateEURToUSD;
			return newValue;
		}
		if(currency1 == "BRL" && currency2 == "USD") {
			Double newValue = value * rateBRLToUSD;
			return newValue;
		}
		if(currency1 == "BRL" && currency2 == "EUR") {
			Double newValue = value * rateBRLToEUR;
			return newValue;
		}
		else {
			return value;
		}
	}
}