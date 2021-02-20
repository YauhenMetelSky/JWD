package test.metelski.quadrangle.comparator;

import by.metelski.quadrangle.comparator.QuadrangleByIdComparator;
import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.Quadrangle;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class QuadrangleByIdComparatorTest extends Assert {
    Quadrangle quadrangle1;
    Quadrangle quadrangle2;
    Quadrangle quadrangle3;
    Quadrangle quadrangle4;

    @BeforeTest
    public void setUp() {
        quadrangle1 = new Quadrangle(new CustomPoint(-4, -3), new CustomPoint(-3, 1), new CustomPoint(1, 3), new CustomPoint(-2, -2));
        quadrangle1.setId(12);
        quadrangle2 = new Quadrangle(new CustomPoint(0, -3), new CustomPoint(6, 2), new CustomPoint(3, 7), new CustomPoint(1, 4));
        quadrangle2.setId(12);
        quadrangle3 = new Quadrangle(new CustomPoint(0, 0), new CustomPoint(5, 7), new CustomPoint(6, 5), new CustomPoint(6, -7));
        quadrangle3.setId(58943);
        quadrangle4 = new Quadrangle(new CustomPoint(0, -3), new CustomPoint(6, 2), new CustomPoint(3, 7), new CustomPoint(1, 4));
        quadrangle4.setId(35484);
    }

    @AfterTest
    public void tearDown() {
        quadrangle4 = null;
        quadrangle3 = null;
        quadrangle2 = null;
        quadrangle1 = null;
    }

    @Test(dataProvider = "testCompareData")
    public void testCompare(Quadrangle quadrangle1, Quadrangle quadrangle2, int expectedResult) {
        int actualResult = new QuadrangleByIdComparator().compare(quadrangle1, quadrangle2);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider
    public Object[][] testCompareData() {
        return new Object[][]{
                {quadrangle1, quadrangle2, 0},
                {quadrangle1, quadrangle3, -1},
                {quadrangle1, quadrangle4, -1},
                {quadrangle2, quadrangle3, -1},
                {quadrangle2, quadrangle4, -1},
                {quadrangle3, quadrangle4, 1}
        };
    }
}
