package test.metelski.xmltask.validation;

import by.metelski.xmltask.exception.CustomXMLParseException;
import by.metelski.xmltask.validation.CustomXMLValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomXMLValidatorTest extends Assert {

    @Test
    public void testIsXMLValid() throws CustomXMLParseException {
        boolean expectedResult = true;
        boolean actualResult = CustomXMLValidator.isXMLValid("testData/testmed.xml", "testdata/testmed.xsd");
        assertEquals(actualResult, expectedResult);
    }
}
