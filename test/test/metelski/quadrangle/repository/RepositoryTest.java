package test.metelski.quadrangle.repository;

import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.repository.Repository;
import by.metelski.quadrangle.repository.Specification;
import by.metelski.quadrangle.repository.impl.FindById;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RepositoryTest extends Assert {
    long id=14;
    Repository repository;
    List<Quadrangle> expectedResult=new ArrayList<>();
    Specification specification;
    List<Quadrangle> actualResult;

    @BeforeTest
    public void setUp(){
        Quadrangle quadrangle1=new Quadrangle(new CustomPoint(-4,-2),new CustomPoint(-3,1),new CustomPoint(1,3),new CustomPoint(-2,-2));
        Quadrangle quadrangle2=new Quadrangle(new CustomPoint(0,0),new CustomPoint(4,6),new CustomPoint(6,5),new CustomPoint(6,-7));
        Quadrangle quadrangle3=new Quadrangle(new CustomPoint(0,-3),new CustomPoint(5,2),new CustomPoint(3,7),new CustomPoint(1,4));
        Quadrangle quadrangle4=new Quadrangle(new CustomPoint(6,5),new CustomPoint(4,4),new CustomPoint(3,2),new CustomPoint(7,3));
        Quadrangle quadrangle5=new Quadrangle(new CustomPoint(1,3),new CustomPoint(4,6),new CustomPoint(6,5),new CustomPoint(6,0));
        Quadrangle quadrangle6=new Quadrangle(new CustomPoint(-6,1),new CustomPoint(-8,3),new CustomPoint(-6,6),new CustomPoint(-4,3));
        Quadrangle quadrangle7=new Quadrangle(new CustomPoint(0,0),new CustomPoint(6,0),new CustomPoint(6,6),new CustomPoint(0,6));
        Quadrangle quadrangle8=new Quadrangle(new CustomPoint(0,0),new CustomPoint(6,0),new CustomPoint(6,-6),new CustomPoint(0,-6));
        Quadrangle quadrangle9=new Quadrangle(new CustomPoint(0,0),new CustomPoint(-6,0),new CustomPoint(-6,6),new CustomPoint(0,6));
        Quadrangle quadrangle10=new Quadrangle(new CustomPoint(0,0),new CustomPoint(0,-6),new CustomPoint(-6,-6),new CustomPoint(-6,0));
        expectedResult.add(quadrangle3);
        repository =new Repository();
        repository.add(quadrangle1);
        repository.add(quadrangle2);
        repository.add(quadrangle3);
        repository.add(quadrangle4);
        repository.add(quadrangle5);
        repository.add(quadrangle6);
        repository.add(quadrangle7);
        repository.add(quadrangle8);
        repository.add(quadrangle9);
        repository.add(quadrangle10);

    }
    @AfterTest
    public void tearDown(){
        repository =null;
        specification=null;

    }
    @Test()
    public void testQueryById(){
        specification = new FindById(id);
        actualResult=repository.query(specification);
        assertEquals(actualResult,expectedResult);
    }
}
