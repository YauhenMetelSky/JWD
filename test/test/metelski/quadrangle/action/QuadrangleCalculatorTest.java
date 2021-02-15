package test.metelski.quadrangle.action;

import by.metelski.quadrangle.action.impl.QuadrangleCalculator;
import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.Quadrangle;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class QuadrangleCalculatorTest extends Assert {
    Quadrangle testQuadrangle;
    QuadrangleCalculator calculator;
    @BeforeTest
    public void setUp() {
        CustomPoint pointA = new CustomPoint(1,4);
        CustomPoint pointB = new CustomPoint(3,7);
        CustomPoint pointC = new CustomPoint(5,2);
        CustomPoint pointD = new CustomPoint(0,-3);
        testQuadrangle=new Quadrangle(pointA,pointB,pointC,pointD,"shape");
        calculator=new QuadrangleCalculator();
    }
    @AfterTest
    public void tearDown() {
        testQuadrangle=null;
    }
    @Test
    public void testFindSides(){
        double[]expectedResult ={3.6055,5.3851,7.071,7.071};
        double[]actualResult = calculator.findSides(testQuadrangle);
        assertEquals(actualResult,expectedResult,4);
    }
    @Test
    public void testFindPerimeter() {
        double expectedResult =23.1326;
        double actualResult = calculator.findPerimeter(testQuadrangle);
        assertEquals(actualResult,expectedResult,4);
    }
    @Test
    public void testFindDiagonals(){
        double[] expectedResult={4.4721,10.4403};
        double[] actualResult = calculator.findDiagonals(testQuadrangle);
        assertEquals(actualResult,expectedResult,4);
    }
    @Test(dataProvider = "findSquareData")
    public void testFindSquare(Quadrangle quadrangle,double expectedResult2){
        double actualResult = calculator.findArea(quadrangle);
        assertEquals(actualResult,expectedResult2,4);

    }
    @DataProvider(name = "findSquareData")
    public Object[][] findSquareData() {
        return new Object[][]{{new Quadrangle(new CustomPoint(1,4),new CustomPoint(3,7),new CustomPoint(5,2),new CustomPoint(0,-3),"shape"),22.9995},
                {new Quadrangle(new CustomPoint(9,0),new CustomPoint(9,4),new CustomPoint(13,4),new CustomPoint(13,0),"shape"),16.0}
        };
    }
}
