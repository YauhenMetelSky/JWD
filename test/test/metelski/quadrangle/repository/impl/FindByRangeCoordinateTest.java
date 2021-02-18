package test.metelski.quadrangle.repository.impl;

import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.repository.impl.FindByRangeCoordinate;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FindByRangeCoordinateTest extends Assert {
    private Quadrangle quadrangle;
    private FindByRangeCoordinate specification;

    @BeforeTest
    public void setUp() {
        quadrangle = new Quadrangle(new CustomPoint(-4, -2), new CustomPoint(-3, 1), new CustomPoint(1, 3), new CustomPoint(-2, -2));
    }

    @AfterTest
    public void tearDown() {
        quadrangle = null;
        specification = null;
    }

    @Test(dataProvider = "findByRangeCoordinateData")
    public void testSpecify(int minX, int maxX, int minY, int maxY,boolean expectedResult) {
        specification = new FindByRangeCoordinate(minX, maxX, minY, maxY);
        boolean actualResult = specification.specify(quadrangle);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider()
    public Object[][] findByRangeCoordinateData() {
        return new Object[][]{
                {-3, 3, -4, 4,false},
                {-5, 0, -4, 4,false},
                {-5, 3, -1, 4,false},
                {-5, 3, -4, 2,false},
                {-5, 3, -4, 4,true}
        };
    }
}
