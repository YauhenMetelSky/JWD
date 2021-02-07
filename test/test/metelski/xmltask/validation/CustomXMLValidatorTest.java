package test.metelski.xmltask.validation;

import by.metelski.xmltask.validation.CustomXMLValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomXMLValidatorTest extends Assert {
    private String filename ="testdata/testmed.xml";
    private String schemaName ="testdata/testmed.xsd";
    private String filenameInvalid ="testdat/testmed.xml";
    private String schemaNameInvalid ="testdata/testme.xsd";
    private String filenameEmpty ="testdata/testmedempty.xml";
    private String schemaNameEmpty ="testdata/testmedempty.xsd";

    @Test
    public void testIsXmlValidPositive() {
        boolean expectedResult = true;
        boolean actualResult = CustomXMLValidator.isXMLValid(filename, schemaName);
        assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testIsXMLValidInvalidXmlName() {
        boolean expectedResult = false;
        boolean actualResult = CustomXMLValidator.isXMLValid(filenameInvalid, schemaName);
        assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testIsXMLValidInvalidXsdName() {
        boolean expectedResult = false;
        boolean actualResult = CustomXMLValidator.isXMLValid(filename, schemaNameInvalid);
        assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testIsXmlValidNegative() {
        boolean expectedResult = false;
        boolean actualResult = CustomXMLValidator.isXMLValid(filename, null);
        assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testIsXmlValidEmptyFile() {
        boolean expectedResult = false;
        boolean actualResult = CustomXMLValidator.isXMLValid(filenameEmpty, schemaName);
        assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testIsXsdValidEmptyFile() {
        boolean expectedResult = false;
        boolean actualResult = CustomXMLValidator.isXMLValid(filename, schemaNameEmpty);
        assertEquals(actualResult, expectedResult);
    }

}
