package model.converter;

public class Converter {

	private static Double rateUSDToBRL = 4.9003;
	private static Double rateEURToBRL = 5.3827;
	private static Double rateEURToUSD = 1.0988;
	private static Double rateGBPToBRL = 6.2857;
	private static Double rateGBPToUSD = 1.2918;
	private static Double rateGBPToEUR = 1.1743;
	

	
	public Double conversion(String currency1, String currency2, Double value) {
		if(currency1 == "USD" && currency2 == "BRL") {
			Double newValue = value * rateUSDToBRL;
			return newValue;
		}
		if(currency1 == "USD" && currency2 == "EUR") {
			Double newValue = value / rateEURToUSD;
			return newValue;
		}
		if(currency1 == "USD" && currency2 == "GBP") {
			Double newValue = value / rateGBPToUSD;
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
		if(currency1 == "EUR" && currency2 == "GBP") {
			Double newValue = value / rateGBPToEUR;
			return newValue;
		}
		if(currency1 == "BRL" && currency2 == "USD") {
			Double newValue = value / rateUSDToBRL;
			return newValue;
		}
		if(currency1 == "BRL" && currency2 == "EUR") {
			Double newValue = value / rateEURToBRL;
			return newValue;
		}
		if(currency1 == "BRL" && currency2 == "GBP") {
			Double newValue = value / rateGBPToBRL;
			return newValue;
		}
		if(currency1 == "GBP" && currency2 == "USD") {
			Double newValue = value * rateGBPToUSD;
			return newValue;
		}
		if(currency1 == "GBP" && currency2 == "EUR") {
			Double newValue = value * rateGBPToEUR;
			return newValue;
		}
		if(currency1 == "GBP" && currency2 == "BRL") {
			Double newValue = value * rateGBPToBRL;
			return newValue;
		}
		else {
			return value;
		}
	}
}