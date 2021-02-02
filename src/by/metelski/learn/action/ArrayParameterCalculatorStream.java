package by.metelski.learn.action;

import by.metelski.learn.entity.CustomArray;
import by.metelski.learn.exception.CustomArrayException;
import by.metelski.learn.validation.CheckArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayParameterCalculatorStream {
    public final static Logger logger = LogManager.getLogger();

    public int findMaxValue(CustomArray customArray) throws CustomArrayException {
        if (!CheckArray.isArrayValid(customArray)) {
            throw new CustomArrayException("Illegal argument");
        }
        int[] array = customArray.getArray();
        int maxValue = Arrays.stream(array)
                .max()
                .getAsInt();
        logger.log(Level.INFO, "max value: " + maxValue);
        return maxValue;
    }

    public int findMinValue(CustomArray customArray) throws CustomArrayException {
        if (!CheckArray.isArrayValid(customArray)) {
            throw new CustomArrayException("Illegal argument");
        }
        int[] array = customArray.getArray();
        int minValue = Arrays.stream(array)
                .min()
                .getAsInt();
        logger.log(Level.INFO, "min value: " + minValue);
        return minValue;
    }

    public double findAverageValue(CustomArray customArray) throws CustomArrayException {
        if (!CheckArray.isArrayValid(customArray)) {
            throw new CustomArrayException("Illegal argument");
        }
        int[] array = customArray.getArray();
        double result = Arrays.stream(array)
                .average()
                .getAsDouble();
        logger.log(Level.INFO, "Average value: " + result);
        return result;
    }

    public int findNumberNegativeNumbers(CustomArray customArray) throws CustomArrayException {
        if (!CheckArray.isArrayValid(customArray)) {
            throw new CustomArrayException("Illegal argument");
        }
        int[] array = customArray.getArray();
        int counter = (int) Arrays.stream(array)
                .filter(element -> element < 0)
                .count();
        logger.log(Level.INFO, "number of negative numbers: " + counter);
        return counter;
    }

    public int findNumberPositiveNumbers(CustomArray customArray) throws CustomArrayException {
        if (!CheckArray.isArrayValid(customArray)) {
            throw new CustomArrayException("Illegal argument");
        }
        int[] array = customArray.getArray();
        int counter = (int) Arrays.stream(array)
                .filter(element -> element >= 0)
                .count();
        logger.log(Level.INFO, "number of positive numbers: " + counter);
        return counter;
    }

    public int findSumAllElements(CustomArray customArray) throws CustomArrayException {
        if (!CheckArray.isArrayValid(customArray)) {
            throw new CustomArrayException("Illegal argument");
        }
        int[] array = customArray.getArray();
        int sumArrayElements = Arrays.stream(array)
                .sum();
        logger.log(Level.INFO, "sum of all array elements: " + sumArrayElements);
        return sumArrayElements;
    }
}
