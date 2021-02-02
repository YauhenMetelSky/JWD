package test.metelski.learn.validation;

import by.metelski.learn.validation.CheckStringFromFile;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckStringFromFileTest extends Assert {
    @Test
    public void testIsStringValid(){
        String testString = "1,5,8,9,10";
        boolean expectedResult = true;
        boolean actualResult = CheckStringFromFile.isStringValid(testString);
        assertEquals(actualResult,expectedResult);
    }
}
