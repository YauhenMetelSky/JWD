package test.metelski.quadrangle.repository.impl;

import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.repository.impl.FindByPoint;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FindByPointTest extends Assert {
    private Quadrangle quadrangle;
    private FindByPoint specification;

    @BeforeTest
    public void setUp() {
        quadrangle = new Quadrangle(new CustomPoint(5, 2), new CustomPoint(3, 7), new CustomPoint(-2, -5), new CustomPoint(0, 0));
    }

    @AfterTest
    public void tearDown() {
        quadrangle = null;
        specification = null;
    }

    @Test(dataProvider = "testSpecifyData")
    public void testSpecify(CustomPoint point, boolean expectedResult) {
        specification = new FindByPoint(point);
        boolean actualResult = specification.specify(quadrangle);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider
    public Object[][] testSpecifyData() {
        return new Object[][]{
                {new CustomPoint(5, 2), true},
                {new CustomPoint(3, 7), true},
                {new CustomPoint(-2, -5), true},
                {new CustomPoint(0, 0), true},
                {new CustomPoint(12, -9), false}
        };
    }
}
