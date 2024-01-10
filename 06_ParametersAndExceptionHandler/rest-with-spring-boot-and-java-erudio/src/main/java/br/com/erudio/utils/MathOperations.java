package br.com.erudio.utils;

public class MathOperations {
	
	public  Double sum(Double numberOne, Double numberTwo) {

		return numberOne + numberTwo;
	}

	public  Double dif (Double numberOne, Double numberTwo) {

		return numberOne - numberTwo;
	}
	
	public  Double mult (Double numberOne, Double numberTwo) {

		return numberOne * numberTwo;
	}
	
	public  Double div (Double numberOne, Double numberTwo) {

		return numberOne / numberTwo;
	}
	
	public  Double avrg (Double numberOne, Double numberTwo) {

		return (numberOne +  numberTwo)/2;
	}
	
	public  Double sqrroot (Double numberOne) {

		return Math.sqrt(numberOne);
	}
	
}
