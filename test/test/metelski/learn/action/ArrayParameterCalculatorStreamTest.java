package test.metelski.learn.action;

import by.metelski.learn.action.ArrayParameterCalculatorStream;
import by.metelski.learn.entity.CustomArray;
import by.metelski.learn.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArrayParameterCalculatorStreamTest extends Assert {
    private CustomArray customArray;
    private ArrayParameterCalculatorStream arrayParameterCalculatorStream;

    @BeforeTest
    public void setUp() throws CustomArrayException {
        customArray = new CustomArray(new int[]{1, 5, 12, 9, -8, 0, 6, 4, 0, 0});
        arrayParameterCalculatorStream = new ArrayParameterCalculatorStream();
    }

    @AfterTest
    public void tearDown() {
        customArray = null;
        arrayParameterCalculatorStream = null;
    }

    @Test
    public void testFindMaxValue() throws CustomArrayException {
        int expectedResult = 12;
        int actualResult = arrayParameterCalculatorStream.findMaxValue(customArray);
        assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testFindMinValue() throws CustomArrayException {
        int expectedResult = -8;
        int actualResult = arrayParameterCalculatorStream.findMinValue(customArray);
        assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testFindAverageValue() throws CustomArrayException {
        double expectedResult = 2.9;
        double actualResult = arrayParameterCalculatorStream.findAverageValue(customArray);
        assertEquals(actualResult, expectedResult, 0.001);
    }

    @Test
    public void testFindNumberNegativeNumbers() throws CustomArrayException {
        int expectedResult = 1;
        int actualResult = arrayParameterCalculatorStream.findNumberNegativeNumbers(customArray);
        assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testFindNumberPositiveNumbers() throws CustomArrayException {
        int expectedResult = 9;
        int actualResult = arrayParameterCalculatorStream.findNumberPositiveNumbers(customArray);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testFindSumAllElements() throws CustomArrayException {
        int expectedResult = 29;
        int actualResult = arrayParameterCalculatorStream.findSumAllElements(customArray);
        assertEquals(actualResult, expectedResult);
    }
}
