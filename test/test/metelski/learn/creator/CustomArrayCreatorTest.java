package test.metelski.learn.creator;

import by.metelski.learn.creator.CustomArrayCreator;
import by.metelski.learn.entity.CustomArray;
import by.metelski.learn.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayCreatorTest extends Assert {
    private List<CustomArray> expectedResult = new ArrayList<>();
    private String filePath;
    @BeforeTest
    public void setUp() throws CustomArrayException {
        filePath ="data/array.txt";
        expectedResult.add(new CustomArray(new int[]{1,5,18,-9,0,0,-2,0,18,9,2,-85,4}));
        expectedResult.add(new CustomArray(new int[]{48,80,-86,-7,93,-33,86,-85,99,-94,30,61,91,73,24}));
        expectedResult.add(new CustomArray(new int[]{38,22,3,21,45,20,0,30,44,9,0,23,17,35,37}));
    }
    @AfterTest
    public void tearDown(){
        filePath=null;
        expectedResult = null;
    }
    @Test
    public void testCreateCustomArraysFromFile() throws CustomArrayException {
        CustomArrayCreator creator = new CustomArrayCreator();
       List<CustomArray> actualResult= creator.createCustomArraysFromFile(filePath);
       assertEquals(actualResult,expectedResult);

    }
}
