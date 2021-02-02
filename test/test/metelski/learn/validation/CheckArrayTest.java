package test.metelski.learn.validation;

import by.metelski.learn.entity.CustomArray;
import by.metelski.learn.exception.CustomArrayException;
import by.metelski.learn.validation.CheckArray;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckArrayTest extends Assert {
    private CustomArray customArray;

    @BeforeMethod
    public void setUp() throws CustomArrayException {
        customArray = new CustomArray(new int[]{1, -5, 12, 9, -8, 6, 4, -7, 15, -1, 0});


    }

    @AfterMethod
    public void tearDown() {
        customArray = null;

    }
    @Test
    public void testIsArrayValid(){
        boolean expectedResult = false;
        boolean actualResult = CheckArray.isArrayValid(null);
    }
    @Test
    public void testIsArrayValid2() throws CustomArrayException {
        customArray.setArray(new int[]{});
        boolean expectedResult = false;
        boolean actualResult = CheckArray.isArrayValid(customArray);
    }
}
