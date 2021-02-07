package test.metelski.xmltask.validation;

import by.metelski.xmltask.exception.CustomXMLParseException;
import by.metelski.xmltask.validation.CustomXMLValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomXMLValidatorTest extends Assert {

    @Test
    public void testIsXmlValidPositive() {
        boolean expectedResult = true;
        boolean actualResult = CustomXMLValidator.isXMLValid("testData/testmed.xml", "testdata/testmed.xsd");
        assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testIsXMLValidInvalidXmlName() {
        boolean expectedResult = false;
        boolean actualResult = CustomXMLValidator.isXMLValid("testData/testme.xml", "testdata/testmed.xsd");
        assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testIsXMLValidInvalidXsdName() {
        boolean expectedResult = false;
        boolean actualResult = CustomXMLValidator.isXMLValid("testData/testmed.xml", "testdat/testmed.xsd");
        assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testIsXmlValidNegative() {
        boolean expectedResult = false;
        boolean actualResult = CustomXMLValidator.isXMLValid("testData/testmed.xml", null);
        assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testIsXmlValidEmptyFile() {
        boolean expectedResult = false;
        boolean actualResult = CustomXMLValidator.isXMLValid("testData/testmedempty.xml", "testdat/testmed.xsd");
        assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testIsXsdValidEmptyFile() {
        boolean expectedResult = false;
        boolean actualResult = CustomXMLValidator.isXMLValid("testData/testmed.xml", "testdat/testmedempty.xsd");
        assertEquals(actualResult, expectedResult);
    }

}
