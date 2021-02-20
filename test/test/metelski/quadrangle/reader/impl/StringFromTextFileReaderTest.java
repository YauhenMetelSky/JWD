package test.metelski.quadrangle.reader.impl;

import by.metelski.quadrangle.exception.QuadrangleException;
import by.metelski.quadrangle.reader.impl.StringFromTextFileReader;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class StringFromTextFileReaderTest extends Assert {
    String filePath;
    List<String> expectedResult ;
    StringFromTextFileReader reader;
    @BeforeTest
    public void setUp(){
        filePath = "data/testData.txt";
        expectedResult = new ArrayList<>();
        expectedResult.add("0,0 10,7 12,3 11,-12");
        expectedResult.add("1,1 11,8 13,4 12,-13");
        expectedResult.add("0,0 10,7 12,3 11,-12");
        expectedResult.add("1,1 11,8 13,4 12,-13");
        expectedResult.add("");
        expectedResult.add("-2f,g 8,7f 99,138,1 1,--1");
        expectedResult.add("0,0 0,0 1,1 -1,-1");
        expectedResult.add("0,0 0,0 1,1 -1,1");
        expectedResult.add("146846 13684 643 5456 34654 434 4465kjjh hhui jhi");
        expectedResult.add(";lajdf jhah; ;aduj ooyha  lghlua    aooiguoi");
    }
    @AfterTest
    public void tearDown(){
        expectedResult = null;
        filePath = null;
        reader=null;
    }
    @Test
    public void testReadStringsFromFile() throws QuadrangleException {
        reader = new StringFromTextFileReader();
        List<String> actualResult = reader.readStringsFromFile(filePath);
        assertEquals(actualResult,expectedResult);
    }
}
