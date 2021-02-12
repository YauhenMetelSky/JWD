package test.metelski.quadrangle.validate;

import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.validate.CheckStringFromFile;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckStringFromFileTest extends Assert {
    @Test(dataProvider = "isStringValid")
    public void testIsStringValid(String testString, boolean expectedResult){
        boolean actualResult = CheckStringFromFile.isStringValid(testString);
        assertEquals(actualResult,expectedResult);

    }
    @DataProvider(name = "isStringValid")
    public Object[][] isStringValidData() {
        return new Object[][]{{"1,1 2,2 3,-5 2,-7",true},
                {"1,1 -1,-1 -1,1 1,-1",true},
                {"1,1d -1f,-1 -1,1 1,-1",false},
                {"1,1 -1,-1 -1,1 1,-1 12,12",false},
                {"1,1 -1,-1 -1,11,-1",false},
                {"fffff",false},
                {"1235",false},
                {"",false}
        };
    }
}
