package by.metelski.quadrangle.parser.impl;

import by.metelski.quadrangle.parser.CustomParseInterface;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomParser implements CustomParseInterface {
    public static final String PATTERN_NUMBER = "-*\\d+";
    public final static Logger logger = LogManager.getLogger();

    public int[] parseArrayFromString(String string) {
        Pattern pattern = Pattern.compile(PATTERN_NUMBER);
        Matcher matcher = pattern.matcher(string);
        int arraySize = findArraySize(matcher);
        int[] array = new int[arraySize];
        int counter = 0;
        matcher.reset();
        while (matcher.find()) {
            array[counter] = Integer.parseInt(matcher.group());
            counter++;
        }
        logger.log(Level.INFO,"return parsed points array" + Arrays.toString(array));
        return array;
    }

    private static int findArraySize(Matcher matcher) {
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }
}
