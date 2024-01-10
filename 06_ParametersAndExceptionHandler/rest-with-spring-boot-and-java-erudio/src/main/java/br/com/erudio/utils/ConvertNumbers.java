package br.com.erudio.utils;

public class ConvertNumbers {
	
	public static Double convertToDouble(String strNumber) {
		if(strNumber== null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if(CheckNumbers.isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}
}
