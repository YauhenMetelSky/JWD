package test.metelski.quadrangle.parser.impl;

import by.metelski.quadrangle.parser.impl.CustomParser;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomParserTest extends Assert {
    private CustomParser customParser;

    @BeforeTest
    public void setUp() {
        customParser = new CustomParser();
    }

    @AfterTest
    public void tearDown() {
        customParser = null;
    }

    @Test(dataProvider = "ParseArrayFromString")
    public void testParseArrayFromString(String string, int[] expectedResult) {
        int[] actualResult = customParser.parseArrayFromString(string);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "ParseArrayFromString")
    public Object[][] isStringValidData() {
        return new Object[][]{{"1,1 2,2 3,-5 2,-7", new int[]{1, 1, 2, 2, 3, -5, 2, -7}},
                {"1,1 -1,-1 -1,1 1,-1", new int[]{1, 1, -1, -1, -1, 1, 1, -1}}
        };
    }
}
