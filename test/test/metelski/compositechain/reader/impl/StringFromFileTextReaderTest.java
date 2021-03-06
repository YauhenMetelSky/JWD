package test.metelski.compositechain.reader.impl;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import by.metelski.compositechain.exception.CompositeException;
import by.metelski.compositechain.reader.impl.StringFromFileTextReader;

public class StringFromFileTextReaderTest extends Assert {
	String filePath;
	String expectedResult;
	String actualResult;
	StringFromFileTextReader reader;
	
	@BeforeTest
	public void setUp() {
		filePath = "data/testData.txt";
		expectedResult = "\\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!\\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?";
	}
	@AfterTest
	public void tearDown() {
		expectedResult = null;
		actualResult = null;
		filePath = null;
		reader = null;
	}
	@Test
	public void testReadStringsFromFile() throws CompositeException {
		reader = new StringFromFileTextReader();
		actualResult = reader.readStringsFromFile(filePath);
		System.out.println(actualResult);
		assertEquals(actualResult, expectedResult);
	}
}
