package test.metelski.quadrangle.factory.impl;

import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.exception.QuadrangleException;
import by.metelski.quadrangle.factory.impl.ShapeFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShapeFactoryTest extends Assert {
    Quadrangle expectedResultFirstTest;
    Quadrangle expectedResultSecondTest;
    Quadrangle expectedResultThirdTest;
    Quadrangle expectedResultFourthTest;
    Quadrangle actualResult;
    ShapeFactory factory;

    @BeforeTest
    public void setUp() {
        factory = new ShapeFactory();
        expectedResultFirstTest = new Quadrangle(new CustomPoint(-4, -2), new CustomPoint(-3, 1), new CustomPoint(1, 3), new CustomPoint(-2, -2));
        expectedResultSecondTest = new Quadrangle(new CustomPoint(0, 0), new CustomPoint(4, 6), new CustomPoint(6, 5), new CustomPoint(6, -7));
        expectedResultThirdTest = new Quadrangle(new CustomPoint(0, -3), new CustomPoint(5, 2), new CustomPoint(3, 7), new CustomPoint(1, 4));
        expectedResultFourthTest = new Quadrangle(new CustomPoint(6, 5), new CustomPoint(4, 4), new CustomPoint(3, 2), new CustomPoint(7, 3));
    }

    @AfterTest
    public void tearDown() {
        factory = null;
        expectedResultFirstTest = null;
        expectedResultSecondTest = null;
        expectedResultThirdTest = null;
        expectedResultFourthTest = null;
        actualResult = null;
    }

    @Test(dataProvider = "createShapeData")
    public void testCreateShape(CustomPoint[] points, Quadrangle expectedResult) throws QuadrangleException {
        actualResult = (Quadrangle) factory.createShape(points);
        expectedResult.setId(actualResult.getId());
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "createShapeData")
    public Object[][] createShapeData() {
        return new Object[][]{
                {new CustomPoint[]{new CustomPoint(-4, -2), new CustomPoint(-3, 1), new CustomPoint(1, 3), new CustomPoint(-2, -2)}, expectedResultFirstTest},
                {new CustomPoint[]{new CustomPoint(0, 0), new CustomPoint(4, 6), new CustomPoint(6, 5), new CustomPoint(6, -7)}, expectedResultSecondTest},
                {new CustomPoint[]{new CustomPoint(0, -3), new CustomPoint(3, 7), new CustomPoint(5, 2), new CustomPoint(1, 4)}, expectedResultThirdTest},
                {new CustomPoint[]{new CustomPoint(6, 5), new CustomPoint(3, 2), new CustomPoint(4, 4), new CustomPoint(7, 3)}, expectedResultFourthTest}
        };
    }
}
