package test.metelski.learn.reader;

import by.metelski.learn.exception.CustomArrayException;
import by.metelski.learn.reader.StringFromTextFileReader;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class StringFromTextFileReaderTest extends Assert {
    String filePath;
    List<String> expectedResult ;
    @BeforeTest
    public void setUp(){
        filePath = "data/array.txt";
        expectedResult = new ArrayList<>();
        expectedResult.add("1,5,18,-9,0,0,-2,0,18,9,2,-85,4");
        expectedResult.add("48 80 -86 -7 93 -33 86 -85 99 -94 30 61 91 73 24");
        expectedResult.add("35,z4, 4z5c, aaa");
        expectedResult.add("38 22 3 21 45 20 0 30 44 9 0 23 17 35 37");
    }
    @AfterTest
    public void tearDown(){
        expectedResult = null;
        filePath = null;
    }
    @Test
    public void testReadStringsFromFile() throws CustomArrayException {
        StringFromTextFileReader reader = new StringFromTextFileReader();
        List<String> actualResult = reader.readStringsFromFile(filePath);
        assertEquals(actualResult,expectedResult);
    }
}
