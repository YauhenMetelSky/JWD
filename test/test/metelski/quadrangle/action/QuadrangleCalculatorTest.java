package test.metelski.quadrangle.action;

import by.metelski.quadrangle.action.QuadrangleCalculator;
import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.exception.QuadrangleException;
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
        CustomPoint pointA = new CustomPoint(1,4,"A");
        CustomPoint pointB = new CustomPoint(3,7,"B");
        CustomPoint pointC = new CustomPoint(5,2,"C");
        CustomPoint pointD = new CustomPoint(0,-3,"D");
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
    public Object[][] sortCustomArrayData() {
        return new Object[][]{{new Quadrangle(new CustomPoint(1,4,"A"),new CustomPoint(3,7,"B"),new CustomPoint(5,2,"C"),new CustomPoint(0,-3,"D"),"shape"),22.9995},
                {new Quadrangle(new CustomPoint(9,0,"A"),new CustomPoint(9,4,"B"),new CustomPoint(13,4,"C"),new CustomPoint(13,0,"D"),"shape"),16.0}
        };
    }
}
