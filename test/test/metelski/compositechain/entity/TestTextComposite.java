package test.metelski.compositechain.entity;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.Symbol;
import by.metelski.compositechain.entity.TextComposite;

public class TestTextComposite extends Assert {
	TextComposite sentence;
	@BeforeTest
	public void setUp() {
		Symbol l1 = new Symbol('M',ComponentType.SYMBOL);
		Symbol l2 = new Symbol('y',ComponentType.SYMBOL);
		Symbol l3 = new Symbol('c',ComponentType.SYMBOL);
		Symbol l4 = new Symbol('a',ComponentType.SYMBOL);
		Symbol l5 = new Symbol('t',ComponentType.SYMBOL);
		Symbol l6 = new Symbol('n',ComponentType.SYMBOL);
		Symbol l7 = new Symbol('a',ComponentType.SYMBOL);
		Symbol l8 = new Symbol('m',ComponentType.SYMBOL);
		Symbol l9 = new Symbol('e',ComponentType.SYMBOL);
		Symbol l10 = new Symbol('F',ComponentType.SYMBOL);
		Symbol l11 = new Symbol('e',ComponentType.SYMBOL);
		Symbol l12 = new Symbol('n',ComponentType.SYMBOL);
		Symbol l13 = new Symbol('i',ComponentType.SYMBOL);
		Symbol l14 = new Symbol('x',ComponentType.SYMBOL);
		TextComposite word1 = new TextComposite(ComponentType.LEXEME);
		word1.add(l1);
		word1.add(l2);
		TextComposite word2 = new TextComposite(ComponentType.LEXEME);
		word2.add(l3);
		word2.add(l4);
		word2.add(l5);
		TextComposite word3 = new TextComposite(ComponentType.LEXEME);
		word3.add(l6);
		word3.add(l7);
		word3.add(l8);
		word3.add(l9);
		TextComposite word4 = new TextComposite(ComponentType.LEXEME);
		word4.add(l10);
		word4.add(l11);
		word4.add(l12);
		word4.add(l13);
		word4.add(l14);
		sentence = new TextComposite(ComponentType.SENTENCE);
		sentence.add(word1);
		sentence.add(word2);
		sentence.add(word3);
		sentence.add(word4);
	}
	@Test
	public void testCountLeaf() {
		int expectedResult =14;
		int actualResult = sentence.countSymbols();
		assertEquals(actualResult, expectedResult);		
	}	
}
