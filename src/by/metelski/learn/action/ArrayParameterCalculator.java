package by.metelski.learn.action;

import by.metelski.learn.entity.CustomArray;
import by.metelski.learn.exception.CustomArrayException;
import by.metelski.learn.validation.CheckArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayParameterCalculator {
    public final static Logger logger = LogManager.getLogger();

    public int findMaxValue(CustomArray customArray) throws CustomArrayException {
        if (!CheckArray.isArrayValid(customArray)) {
            throw new CustomArrayException("Illegal argument");
        }
        int[] array = customArray.getArray();
        int maxValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (maxValue < array[i]) {
                maxValue = array[i];
            }
        }
        logger.log(Level.INFO, "max value: " + maxValue);
        return maxValue;
    }

    public int findMinValue(CustomArray customArray) throws CustomArrayException {
        if (!CheckArray.isArrayValid(customArray)) {
            throw new CustomArrayException("Illegal argument");
        }

        int[] array = customArray.getArray();
        int minValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (minValue > array[i]) {
                minValue = array[i];
            }
        }
        logger.log(Level.INFO, "min value: " + minValue);
        return minValue;
    }

    public double findAverageValue(CustomArray customArray) throws CustomArrayException {
        int sum = 0;
        double result;
        int[] array = customArray.getArray();
        if (!CheckArray.isArrayValid(customArray)) {
            throw new CustomArrayException("Illegal argument");
        }

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        result = (double) sum / array.length;
        logger.log(Level.INFO, "Average value: " + result);
        return result;
    }

    public int findNumberNegativeNumbers(CustomArray customArray) throws CustomArrayException {
        if (!CheckArray.isArrayValid(customArray)) {
            throw new CustomArrayException("Illegal argument");
        }
        int counter = 0;
        int[] array = customArray.getArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                counter++;
            }
        }
        logger.log(Level.INFO, "number of negative numbers: " + counter);
        return counter;
    }

    public int findNumberPositiveNumbers(CustomArray customArray) throws CustomArrayException {
        if (!CheckArray.isArrayValid(customArray)) {
            throw new CustomArrayException("Illegal argument");
        }
        int counter = 0;
        int[] array = customArray.getArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                counter++;
            }
        }
        logger.log(Level.INFO, "number of positive numbers: " + counter);
        return counter;
    }

    public int findSumAllElements(CustomArray customArray) throws CustomArrayException {
        if (!CheckArray.isArrayValid(customArray)) {
            throw new CustomArrayException("Illegal argument");
        }
        int sumArrayElements = 0;
        int[] array = customArray.getArray();
        for (int i = 0; i < array.length; i++) {
            sumArrayElements += array[i];
        }
        logger.log(Level.INFO, "sum of all array elements: " + sumArrayElements);
        return sumArrayElements;
    }
}
