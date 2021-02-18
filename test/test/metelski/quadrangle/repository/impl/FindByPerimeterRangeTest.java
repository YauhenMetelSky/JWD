package test.metelski.quadrangle.repository.impl;

import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.repository.impl.FindByPerimeterRange;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FindByPerimeterRangeTest extends Assert {
    private Quadrangle quadrangle;
    private FindByPerimeterRange specification;

    @BeforeTest
    public void setUp() {
        quadrangle = new Quadrangle(new CustomPoint(1, 4), new CustomPoint(3, 7), new CustomPoint(5, 2), new CustomPoint(0, -3));
    }

    @AfterTest
    public void tearDown() {
        quadrangle = null;
        specification = null;
    }

    @Test(dataProvider = "testSpecifyData")
    public void testSpecify(double minPerimeter, double maxPerimeter, boolean expectedResult) {
        specification = new FindByPerimeterRange(minPerimeter, maxPerimeter);
        boolean actualResult = specification.specify(quadrangle);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider
    public Object[][] testSpecifyData() {
        return new Object[][]{
                {12.5, 30.4, true},
                {12.7, 22.2, false},
                {24.0,30.0,false},
                {0, 0, false}

        };

    }
}
