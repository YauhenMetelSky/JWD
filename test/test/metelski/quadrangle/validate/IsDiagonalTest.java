package test.metelski.quadrangle.validate;

import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.validate.IsDiagonal;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsDiagonalTest extends Assert {
    @Test(dataProvider = "isDiagonal")
    public void testIsDiagonal(CustomPoint[] points, boolean expectedResult) {
        boolean actualResult = IsDiagonal.isPointOneThreeDiagonal(points);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "isDiagonal")
    public Object[][] isDiagonalData() {
        return new Object[][]{{new CustomPoint[]{new CustomPoint(3, 2), new CustomPoint(4, 4), new CustomPoint(6, 5), new CustomPoint(7, 3)}, true},
                {new CustomPoint[]{new CustomPoint(3, 2), new CustomPoint(6, 5), new CustomPoint(4, 4), new CustomPoint(7, 3)}, false},
                {new CustomPoint[]{new CustomPoint(-3, 2), new CustomPoint(-6, 3), new CustomPoint(-6, 1), new CustomPoint(-5, -1)}, true},
                {new CustomPoint[]{new CustomPoint(6, 0), new CustomPoint(10, 4), new CustomPoint(4, 6), new CustomPoint(1, 3)}, true},
                {new CustomPoint[]{new CustomPoint(9, 3), new CustomPoint(12, 5), new CustomPoint(11, 3), new CustomPoint(13, 1)}, true}
        };
    }
}
