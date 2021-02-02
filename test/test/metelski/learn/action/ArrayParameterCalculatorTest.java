package test.metelski.learn.action;

import by.metelski.learn.action.ArrayParameterCalculator;
import by.metelski.learn.action.ArrayParameterCalculatorStream;
import by.metelski.learn.entity.CustomArray;
import by.metelski.learn.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArrayParameterCalculatorTest extends Assert {
    private CustomArray customArray;
    private ArrayParameterCalculator arrayParameterCalculator;

    @BeforeTest
    public void setUp() throws CustomArrayException {
        customArray = new CustomArray(new int[]{1, 5, 12, 9, -8, 0, 6, 4, 0, 0});
        arrayParameterCalculator = new ArrayParameterCalculator();
    }

    @AfterTest
    public void tearDown() {
        customArray = null;
        arrayParameterCalculator = null;
    }

    @Test
    public void testFindMaxValue() throws CustomArrayException {
        int expectedResult = 12;
        int actualResult = arrayParameterCalculator.findMaxValue(customArray);
        assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testFindMinValue() throws CustomArrayException {
        int expectedResult = -8;
        int actualResult = arrayParameterCalculator.findMinValue(customArray);
        assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testFindAverageValue() throws CustomArrayException {
        double expectedResult = 2.9;
        double actualResult = arrayParameterCalculator.findAverageValue(customArray);
        assertEquals(actualResult, expectedResult, 0.001);
    }

    @Test
    public void testFindNumberNegativeNumbers() throws CustomArrayException {
        int expectedResult = 1;
        int actualResult = arrayParameterCalculator.findNumberNegativeNumbers(customArray);
        assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testFindNumberPositiveNumbers() throws CustomArrayException {
        int expectedResult = 9;
        int actualResult = arrayParameterCalculator.findNumberPositiveNumbers(customArray);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testFindSumAllElements() throws CustomArrayException {
        int expectedResult = 29;
        int actualResult = arrayParameterCalculator.findSumAllElements(customArray);
        assertEquals(actualResult, expectedResult);
    }
}
