package util;

public class CurrencyConverter {
	public static double dollarRate;
	public static double amount;

	public static double convertToReal() {
		return dollarRate * amount * 1.06;
	}
}
