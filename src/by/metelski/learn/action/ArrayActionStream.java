package by.metelski.learn.action;

import by.metelski.learn.entity.CustomArray;
import by.metelski.learn.exception.CustomArrayException;
import by.metelski.learn.validation.CheckArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class ArrayActionStream {
    public final static Logger logger = LogManager.getLogger();

    public void replaceAllNegativeElements(CustomArray customArray, int numberToReplace) throws CustomArrayException {
        if (!CheckArray.isArrayValid(customArray)) {
            throw new CustomArrayException("Illegal argument");
        }
        logger.log(Level.INFO, "replaceAllNegativeElements, number to replace: " + numberToReplace);
        int[] array = Arrays.stream(customArray.getArray())
                .map(element -> element < 0 ? numberToReplace : element)
                .toArray();
        customArray.setArray(array);
        logger.log(Level.INFO, "all negative elements replaced for number: " + numberToReplace);
    }

    public void replaceAllNumbersAboveNine(CustomArray customArray, int numberToReplace) throws CustomArrayException {
        if (!CheckArray.isArrayValid(customArray)) {
            throw new CustomArrayException("Illegal argument");
        }
        logger.log(Level.INFO, "replaceAllNumbersAboveNull, number to replace: " + numberToReplace);
        int[] array = Arrays.stream(customArray.getArray())
                .map(element -> element > 9 ? numberToReplace : element)
                .toArray();
        customArray.setArray(array);
        logger.log(Level.INFO, "all elements above nine replaced for number: " + numberToReplace);
    }
}
