package by.metelski.multithreading.parser.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.metelski.multithreading.parser.CarDataParserInterface;

public class CarDataParser implements CarDataParserInterface {
	public static final String PATTERN_SPACE = " ";
	public final static Logger logger = LogManager.getLogger();

	@Override
	public List<Integer> parseArrayFromString(String string) {
		String[] strings = string.split(PATTERN_SPACE);
		List<Integer> carsSpecification = new ArrayList<>();
		for(String element: strings) {
    	   Integer number = Integer.parseInt(element);
    	   carsSpecification.add(number);
       }
		logger.log(Level.INFO, "return parsed array"+ carsSpecification.toString());
		return carsSpecification;
	}
}
