package test.metelski.learn.parser;

import by.metelski.learn.exception.CustomArrayException;
import by.metelski.learn.parser.CustomParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomParserTest extends Assert {
    @Test
    public void testParseArrayFromString() throws CustomArrayException  {
        String testString = "1,-5,8,-9,10,0,954";
        CustomParser customParser = new CustomParser();
        int[] expectedResult = {1,-5,8,-9,10,0,954};
        int[] actualResult = customParser.parseArrayFromString(testString);
        assertEquals(actualResult,expectedResult);
    }
}
