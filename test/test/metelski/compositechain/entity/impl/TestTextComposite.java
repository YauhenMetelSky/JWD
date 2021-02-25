package metelski.compositechain.entity.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.impl.Leaf;
import by.metelski.compositechain.entity.impl.TextComposite;

public class TestTextComposite extends Assert {
	TextComposite sentence;
	@BeforeTest
	public void setUp() {
		Leaf l1 = new Leaf('M',ComponentType.SYMBOL);
		Leaf l2 = new Leaf('y',ComponentType.SYMBOL);
		Leaf l3 = new Leaf('c',ComponentType.SYMBOL);
		Leaf l4 = new Leaf('a',ComponentType.SYMBOL);
		Leaf l5 = new Leaf('t',ComponentType.SYMBOL);
		Leaf l6 = new Leaf('n',ComponentType.SYMBOL);
		Leaf l7 = new Leaf('a',ComponentType.SYMBOL);
		Leaf l8 = new Leaf('m',ComponentType.SYMBOL);
		Leaf l9 = new Leaf('e',ComponentType.SYMBOL);
		Leaf l10 = new Leaf('F',ComponentType.SYMBOL);
		Leaf l11 = new Leaf('e',ComponentType.SYMBOL);
		Leaf l12 = new Leaf('n',ComponentType.SYMBOL);
		Leaf l13 = new Leaf('i',ComponentType.SYMBOL);
		Leaf l14 = new Leaf('x',ComponentType.SYMBOL);
		TextComposite word1 = new TextComposite(ComponentType.WORD);
		word1.add(l1);
		word1.add(l2);
		TextComposite word2 = new TextComposite(ComponentType.WORD);
		word2.add(l3);
		word2.add(l4);
		word2.add(l5);
		TextComposite word3 = new TextComposite(ComponentType.WORD);
		word3.add(l6);
		word3.add(l7);
		word3.add(l8);
		word3.add(l9);
		TextComposite word4 = new TextComposite(ComponentType.WORD);
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
		int actualResult = sentence.countLeaf();
		assertEquals(actualResult, expectedResult);
		
	}
	

}
