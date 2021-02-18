package test.metelski.quadrangle.validate;

import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.validate.CreateValidator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateValidatorTest extends Assert {
    @Test(dataProvider = "isPossibleCreateData")
    public void testIsPossibleCreate(CustomPoint[] points, boolean expectedResult) {
        boolean actualResult = CreateValidator.isPossibleCreate(points);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider()
    public Object[][] isPossibleCreateData() {
        return new Object[][]{
                {new CustomPoint[]{new CustomPoint(-4, 2), new CustomPoint(0, 0), new CustomPoint(1, 3), new CustomPoint(-2, 2)}, true},
                {new CustomPoint[]{new CustomPoint(1, 0), new CustomPoint(6, -7), new CustomPoint(6, 0), new CustomPoint(6, 5)}, true}
        };
    }
}
