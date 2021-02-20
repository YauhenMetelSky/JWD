package test.metelski.quadrangle.repository;

import by.metelski.quadrangle.comparator.QuadrangleByAreaComparator;
import by.metelski.quadrangle.comparator.QuadrangleByFirstPointXComparator;
import by.metelski.quadrangle.comparator.QuadrangleByPerimeterComparator;
import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.repository.Repository;
import by.metelski.quadrangle.repository.Specification;
import by.metelski.quadrangle.repository.impl.FindById;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepositoryTest extends Assert {
    long id = 14;
    Repository repository;
    List<Quadrangle> expectedResult = new ArrayList<>();
    List<Quadrangle> expectedListSortByArea = new ArrayList<>();
    List<Quadrangle> expectedListSortByPerimeter = new ArrayList<>();
    List<Quadrangle> expectedListSortByPointX = new ArrayList<>();
    Specification specification;
    List<Quadrangle> actualResult;

    @BeforeTest
    public void setUp() {
        Quadrangle quadrangle1 = new Quadrangle(new CustomPoint(-4, -2), new CustomPoint(-3, 1), new CustomPoint(1, 3), new CustomPoint(-2, -2));
        Quadrangle quadrangle2 = new Quadrangle(new CustomPoint(0, 0), new CustomPoint(4, 6), new CustomPoint(6, 5), new CustomPoint(6, -7));
        Quadrangle quadrangle3 = new Quadrangle(new CustomPoint(0, -3), new CustomPoint(5, 2), new CustomPoint(3, 7), new CustomPoint(1, 4));
        Quadrangle quadrangle4 = new Quadrangle(new CustomPoint(6, 5), new CustomPoint(4, 4), new CustomPoint(3, 2), new CustomPoint(7, 3));
        Quadrangle quadrangle5 = new Quadrangle(new CustomPoint(1, 3), new CustomPoint(4, 6), new CustomPoint(6, 5), new CustomPoint(6, 0));
        Quadrangle quadrangle6 = new Quadrangle(new CustomPoint(-6, 1), new CustomPoint(-8, 3), new CustomPoint(-6, 6), new CustomPoint(-4, 3));
        Quadrangle quadrangle7 = new Quadrangle(new CustomPoint(0, 0), new CustomPoint(6, 0), new CustomPoint(6, 6), new CustomPoint(0, 6));
        Quadrangle quadrangle8 = new Quadrangle(new CustomPoint(0, 0), new CustomPoint(6, 0), new CustomPoint(6, -6), new CustomPoint(0, -6));
        Quadrangle quadrangle9 = new Quadrangle(new CustomPoint(0, 0), new CustomPoint(-6, 0), new CustomPoint(-6, 6), new CustomPoint(0, 6));
        Quadrangle quadrangle10 = new Quadrangle(new CustomPoint(0, 0), new CustomPoint(0, -6), new CustomPoint(-6, -6), new CustomPoint(-6, 0));
        expectedResult.add(quadrangle3);
        repository = new Repository();
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
        expectedListSortByArea.add(quadrangle4);
        expectedListSortByArea.add(quadrangle1);
        expectedListSortByArea.add(quadrangle6);
        expectedListSortByArea.add(quadrangle5);
        expectedListSortByArea.add(quadrangle3);
        expectedListSortByArea.add(quadrangle7);
        expectedListSortByArea.add(quadrangle8);
        expectedListSortByArea.add(quadrangle9);
        expectedListSortByArea.add(quadrangle10);
        expectedListSortByArea.add(quadrangle2);
        expectedListSortByPerimeter.add(quadrangle4);
        expectedListSortByPerimeter.add(quadrangle6);
        expectedListSortByPerimeter.add(quadrangle1);
        expectedListSortByPerimeter.add(quadrangle5);
        expectedListSortByPerimeter.add(quadrangle3);
        expectedListSortByPerimeter.add(quadrangle7);
        expectedListSortByPerimeter.add(quadrangle8);
        expectedListSortByPerimeter.add(quadrangle9);
        expectedListSortByPerimeter.add(quadrangle10);
        expectedListSortByPerimeter.add(quadrangle2);
        expectedListSortByPointX.add(quadrangle6);
        expectedListSortByPointX.add(quadrangle1);
        expectedListSortByPointX.add(quadrangle3);
        expectedListSortByPointX.add(quadrangle7);
        expectedListSortByPointX.add(quadrangle8);
        expectedListSortByPointX.add(quadrangle9);
        expectedListSortByPointX.add(quadrangle10);
        expectedListSortByPointX.add(quadrangle2);
        expectedListSortByPointX.add(quadrangle5);
        expectedListSortByPointX.add(quadrangle4);
    }

    @AfterTest
    public void tearDown() {
        repository = null;
        specification = null;
        actualResult = null;
        expectedResult = null;
        expectedListSortByArea = null;
        expectedListSortByPerimeter = null;
        expectedListSortByPointX = null;
    }

    @Test()
    public void testQueryById() {
        specification = new FindById(id);
        actualResult = repository.query(specification);
        assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "testSortByParameterData")
    public void testSortByParameter(Comparator<Quadrangle> comparator, List<Quadrangle> expectedList) {
        repository.sortByParameter(comparator);
        actualResult = repository.getAll();
        assertEquals(actualResult, expectedList);
    }

    @DataProvider
    public Object[][] testSortByParameterData() {
        return new Object[][]{
                {new QuadrangleByAreaComparator(), expectedListSortByArea},
                {new QuadrangleByPerimeterComparator(), expectedListSortByPerimeter},
                {new QuadrangleByFirstPointXComparator(), expectedListSortByPointX}
        };
    }
}
