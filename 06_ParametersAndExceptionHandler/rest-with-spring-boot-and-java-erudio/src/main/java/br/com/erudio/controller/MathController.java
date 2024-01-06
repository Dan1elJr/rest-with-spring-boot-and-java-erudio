package br.com.erudio.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.controller.utils.CheckNumbers;
import br.com.erudio.controller.utils.ConvertNumbers;
import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	
	
	private static final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value ="/sum/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double sum (
			@PathVariable(value="numberOne")String numberOne,		
			@PathVariable(value="numberTwo")String numberTwo) throws Exception{
		
		if(!CheckNumbers.isNumeric(numberOne) || !CheckNumbers.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return ConvertNumbers.convertToDouble(numberOne) + ConvertNumbers.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value="/dif/{numberOne}/{numberTwo}")
	public Double dif (
			@PathVariable(value="numberOne")String numberOne,		
			@PathVariable(value="numberTwo")String numberTwo) throws Exception{
		
		if(!CheckNumbers.isNumeric(numberOne) || !CheckNumbers.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return ConvertNumbers.convertToDouble(numberOne) - ConvertNumbers.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}")
	public Double mult (
			@PathVariable(value="numberOne")String numberOne,		
			@PathVariable(value="numberTwo")String numberTwo) throws Exception{
		
		if(!CheckNumbers.isNumeric(numberOne) || !CheckNumbers.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return ConvertNumbers.convertToDouble(numberOne) * ConvertNumbers.convertToDouble(numberTwo);
	}
	
	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}")
	public Double div (
			@PathVariable(value="numberOne")String numberOne,		
			@PathVariable(value="numberTwo")String numberTwo) throws Exception{
		
		if(!CheckNumbers.isNumeric(numberOne) || !CheckNumbers.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		if(numberTwo.contentEquals("0")) {
			
			throw new UnsupportedMathOperationException("Divide operation not support to divide for 0");
		}
		
		return ConvertNumbers.convertToDouble(numberOne) / ConvertNumbers.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value="/avrg/{numberOne}/{numberTwo}")
	public Double avrg (
			@PathVariable(value="numberOne")String numberOne,		
			@PathVariable(value="numberTwo")String numberTwo) throws Exception{
		
		if(!CheckNumbers.isNumeric(numberOne) || !CheckNumbers.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return (ConvertNumbers.convertToDouble(numberOne) + ConvertNumbers.convertToDouble(numberTwo))/2;
	}
	
	@RequestMapping(value="/sqrroot/{numberOne}")
	public Double sqrroot (
			@PathVariable(value="numberOne")String numberOne) throws Exception{
		
		if(!CheckNumbers.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		if(ConvertNumbers.convertToDouble(numberOne)<0) {
			throw new UnsupportedMathOperationException("Do not exists square root for a negative number");
		}
		
		return Math.sqrt(ConvertNumbers.convertToDouble(numberOne));
	}
	
}
