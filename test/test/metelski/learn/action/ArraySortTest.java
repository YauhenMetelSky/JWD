package test.metelski.learn.action;

import by.metelski.learn.action.ArraySort;
import by.metelski.learn.entity.CustomArray;
import by.metelski.learn.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.*;

public class ArraySortTest extends Assert {
    private CustomArray customArray;
    private ArraySort arraySort;

    @BeforeTest
    public void setUp() {
        arraySort = new ArraySort();
    }
    @AfterTest
    public void tearDown() {
        customArray = null;
        arraySort = null;
    }

    @Test(dataProvider = "sortCustomArrayData")
    public void testBubbleSortCustomArray(int[] array, int[] expectedResult) throws CustomArrayException {
        customArray= new CustomArray(array);
        arraySort.bubbleSortCustomArray(customArray);
        int[] actualArray = customArray.getArray();
        assertEquals(actualArray, expectedResult);
    }

    @Test(dataProvider = "sortCustomArrayData")
    public void testInsertionSortCustomArray(int[] array, int[] expectedResult) throws CustomArrayException {
        customArray= new CustomArray(array);
        arraySort.insertionSortCustomArray(customArray);
        int[] actualArray = customArray.getArray();
        assertEquals(actualArray, expectedResult);
    }

    @Test(dataProvider = "sortCustomArrayData")
    public void testSelectionSortCustomArray(int[] array, int[] expectedResult) throws CustomArrayException {
        customArray= new CustomArray(array);
        arraySort.selectionSortCustomArray(customArray);
        int[] actualArray = customArray.getArray();
        assertEquals(actualArray, expectedResult);
    }

    @DataProvider(name = "sortCustomArrayData")
    public Object[][] sortCustomArrayData() {
        return new Object[][]{{new int[]{1, -5, 12, 9, -8, 6, 4, -7, 15, -1, 0}, new int[]{-8, -7, -5, -1, 0, 1, 4, 6, 9, 12, 15}},
                {new int[]{10, 22, -3, 0, 0, -17, 13, -16, -1}, new int[]{-17, -16, -3, -1, 0, 0, 10, 13, 22}}};
    }
}
