package test.metelski.learn.action;

import by.metelski.learn.action.ArrayActionStream;
import by.metelski.learn.entity.CustomArray;
import by.metelski.learn.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArrayActionStreamTest extends Assert {
    private CustomArray customArray;
    private ArrayActionStream arrayActionStream;

    @BeforeMethod
    public void setUp() throws CustomArrayException {
        customArray = new CustomArray(new int[]{1, -5, 12, 9, -8, 6, 4, -7, 15, -1, 0});
        arrayActionStream = new ArrayActionStream();
    }

    @AfterMethod
    public void tearDown() {
        customArray = null;
        arrayActionStream = null;
    }

    @Test
    public void testReplaceAllNegativeElementsToNull() throws CustomArrayException {
        int numberToReplace = 0;
        int[] expectedArray = {1, 0, 12, 9, 0, 6, 4, 0, 15, 0, 0};
        arrayActionStream.replaceAllNegativeElements(customArray, numberToReplace);
        int[] actualArray = customArray.getArray();
        assertEquals(actualArray, expectedArray);
    }

    @Test
    public void testReplaceAllNumbersAboveNine() throws CustomArrayException {
        int numberToReplace = 5;
        int[] expectedArray = {1, -5, 5, 9, -8, 6, 4, -7, 5, -1, 0};
        arrayActionStream.replaceAllNumbersAboveNine(customArray, numberToReplace);
        int[] actualArray = customArray.getArray();
        assertEquals(actualArray, expectedArray);
    }
}
