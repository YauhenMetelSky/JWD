package test.metelski.compositechain.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.metelski.compositechain.action.FindComponent;
import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.Symbol;
import by.metelski.compositechain.entity.TextComponent;
import by.metelski.compositechain.entity.TextComposite;

public class FindComponentTest extends Assert {
	TextComponent expectedResult;
	TextComponent actualResult;
	TextComponent testComposite;
	Map<String, Integer> expectedMap;
	Map<String, Integer> actualMap;
	FindComponent finder;

	@BeforeMethod
	public void setUp() {
		finder = new FindComponent();
		expectedMap = new HashMap<>();
		actualMap = new HashMap<>();
		TextComponent pargraph1 = new TextComposite(ComponentType.PARAGRAPH);
		TextComponent pargraph2 = new TextComposite(ComponentType.PARAGRAPH);
		TextComponent sentence1 = new TextComposite(ComponentType.SENTENCE);
		TextComponent sentence2 = new TextComposite(ComponentType.SENTENCE);
		TextComponent sentence3 = new TextComposite(ComponentType.SENTENCE);
		TextComponent sentence4 = new TextComposite(ComponentType.SENTENCE);
		TextComponent lexeme1 = new TextComposite(ComponentType.LEXEME);
		TextComponent lexeme2 = new TextComposite(ComponentType.LEXEME);
		TextComponent lexeme3 = new TextComposite(ComponentType.LEXEME);
		TextComponent lexeme4 = new TextComposite(ComponentType.LEXEME);
		TextComponent lexeme5 = new TextComposite(ComponentType.LEXEME);
		TextComponent lexeme6 = new TextComposite(ComponentType.LEXEME);
		TextComponent lexeme7 = new TextComposite(ComponentType.LEXEME);
		TextComponent lexeme8 = new TextComposite(ComponentType.LEXEME);
		TextComponent lexeme9 = new TextComposite(ComponentType.LEXEME);
		TextComponent lexeme10 = new TextComposite(ComponentType.LEXEME);
		testComposite = new TextComposite(ComponentType.TEXT);
		Symbol l1 = new Symbol('M', ComponentType.SYMBOL);
		Symbol l2 = new Symbol('y', ComponentType.SYMBOL);
		Symbol l3 = new Symbol('c', ComponentType.SYMBOL);
		Symbol l4 = new Symbol('a', ComponentType.SYMBOL);
		Symbol l5 = new Symbol('t', ComponentType.SYMBOL);
		Symbol l6 = new Symbol('.', ComponentType.PUNCTUATION_MARK);
		Symbol l7 = new Symbol('N', ComponentType.SYMBOL);
		Symbol l8 = new Symbol('a', ComponentType.SYMBOL);
		Symbol l9 = new Symbol('m', ComponentType.SYMBOL);
		Symbol l10 = new Symbol('e', ComponentType.SYMBOL);
		Symbol l11 = new Symbol('-', ComponentType.PUNCTUATION_MARK);
		Symbol l12 = new Symbol('F', ComponentType.SYMBOL);
		Symbol l13 = new Symbol('e', ComponentType.SYMBOL);
		Symbol l14 = new Symbol('n', ComponentType.SYMBOL);
		Symbol l15 = new Symbol('i', ComponentType.SYMBOL);
		Symbol l16 = new Symbol('x', ComponentType.SYMBOL);
		Symbol l17 = new Symbol('!', ComponentType.PUNCTUATION_MARK);
		Symbol l18 = new Symbol('I', ComponentType.SYMBOL);
		Symbol l19 = new Symbol('s', ComponentType.SYMBOL);
		Symbol l20 = new Symbol('h', ComponentType.SYMBOL);
		Symbol l21 = new Symbol('e', ComponentType.SYMBOL);
		Symbol l22 = new Symbol('f', ComponentType.SYMBOL);
		Symbol l23 = new Symbol('a', ComponentType.SYMBOL);
		Symbol l24 = new Symbol('t', ComponentType.SYMBOL);
		Symbol l25 = new Symbol('?', ComponentType.PUNCTUATION_MARK);
		Symbol l26 = new Symbol('C', ComponentType.SYMBOL);
		Symbol l27 = new Symbol('a', ComponentType.SYMBOL);
		Symbol l28 = new Symbol('t', ComponentType.SYMBOL);
		Symbol l29 = new Symbol('n', ComponentType.SYMBOL);
		Symbol l30 = new Symbol('o', ComponentType.SYMBOL);
		Symbol l31 = new Symbol('t', ComponentType.SYMBOL);
		Symbol l32 = new Symbol('f', ComponentType.SYMBOL);
		Symbol l33 = new Symbol('a', ComponentType.SYMBOL);
		Symbol l34 = new Symbol('t', ComponentType.SYMBOL);
		Symbol l35 = new Symbol('?', ComponentType.PUNCTUATION_MARK);
		lexeme1.add(l1);
		lexeme1.add(l2);
		lexeme2.add(l3);
		lexeme2.add(l4);
		lexeme2.add(l5);
		lexeme2.add(l6);
		lexeme3.add(l7);
		lexeme3.add(l8);
		lexeme3.add(l9);
		lexeme3.add(l10);
		lexeme4.add(l11);
		lexeme4.add(l12);
		lexeme4.add(l13);
		lexeme4.add(l14);
		lexeme4.add(l15);
		lexeme4.add(l16);
		lexeme4.add(l17);
		lexeme5.add(l18);
		lexeme5.add(l19);
		lexeme6.add(l20);
		lexeme6.add(l21);
		lexeme7.add(l22);
		lexeme7.add(l23);
		lexeme7.add(l24);
		lexeme7.add(l25);
		lexeme8.add(l26);
		lexeme8.add(l27);
		lexeme8.add(l28);
		lexeme9.add(l29);
		lexeme9.add(l30);
		lexeme9.add(l31);
		lexeme10.add(l32);
		lexeme10.add(l33);
		lexeme10.add(l34);
		lexeme10.add(l35);
		sentence1.add(lexeme1);
		sentence1.add(lexeme2);
		sentence2.add(lexeme3);
		sentence2.add(lexeme4);
		sentence3.add(lexeme5);
		sentence3.add(lexeme6);
		sentence3.add(lexeme7);
		sentence4.add(lexeme8);
		sentence4.add(lexeme9);
		sentence4.add(lexeme10);
		pargraph1.add(sentence1);
		pargraph2.add(sentence2);
		pargraph2.add(sentence3);
		pargraph2.add(sentence4);
		testComposite.add(pargraph1);
		testComposite.add(pargraph2);
		expectedResult = new TextComposite(ComponentType.SENTENCE);
		expectedResult.add(lexeme3);
		expectedResult.add(lexeme4);
		//TODO clean code
//		expectedMap.put(lexeme8.toString().toLowerCase(), 2);
		expectedMap.put(lexeme10.toString().toLowerCase(), 2);
	}

	@AfterMethod
	public void tearDown() {
		expectedResult = null;
		actualResult = null;
		testComposite = null;
		expectedMap = null;
		actualMap = null;
		finder = null;
	}

	@Test
	public void testFindSentence() {
		actualResult = finder.findSentenceWithLongestWord(testComposite);
		assertEquals(actualResult, expectedResult);
	}

	@Test
	public void testFindIdenticalWords() {
		actualMap = finder.findIdenticalWords(testComposite);
		assertEquals(actualMap, expectedMap);
	}
}
