package test.metelski.compositechain.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.metelski.compositechain.action.CompositeAction;
import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.LettersType;
import by.metelski.compositechain.entity.Symbol;
import by.metelski.compositechain.entity.TextComponent;
import by.metelski.compositechain.entity.TextComposite;

public class CompositeActionTest extends Assert {
	List<TextComponent> expectedResult;
	List<TextComponent> actualResult;
	TextComponent expectedResultAfterDel;
	TextComponent testComposite;
	Map<String, Integer> expectedMap;
	Map<String, Integer> actualMap;
	CompositeAction finder;
	TextComponent paragraph;
	TextComponent sentence;
	
	@BeforeMethod
	public void setUp() {
	
		finder = new CompositeAction();
		expectedMap = new HashMap<>();
		actualMap = new HashMap<>();
		expectedResult = new ArrayList<>();
		expectedResultAfterDel = new TextComposite(ComponentType.TEXT);
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
		TextComponent expSentence1 = new TextComposite(ComponentType.SENTENCE);
		TextComponent expSentence2= new TextComposite(ComponentType.SENTENCE);
		TextComponent expSentence3= new TextComposite(ComponentType.SENTENCE);
		TextComponent expSentence4= new TextComposite(ComponentType.SENTENCE);
		expSentence1.add(lexeme2);
		expSentence2.add(lexeme3);
		expSentence2.add(lexeme4);
		expSentence3.add(lexeme7);
		expSentence4.add(lexeme8);
		expSentence4.add(lexeme9);
		expSentence4.add(lexeme10);
		TextComponent expParagraph1= new TextComposite(ComponentType.PARAGRAPH);
		TextComponent expParagraph2= new TextComposite(ComponentType.PARAGRAPH);
		expParagraph1.add(expSentence1);
		expParagraph2.add(expSentence2);
		expParagraph2.add(expSentence3);
		expParagraph2.add(expSentence4);
		expectedResultAfterDel.add(lexeme2);
		expectedResultAfterDel.add(lexeme3);
		expectedResultAfterDel.add(lexeme4);
		expectedResultAfterDel.add(lexeme7);
		expectedResultAfterDel.add(lexeme8);
		expectedResultAfterDel.add(lexeme9);
		expectedResultAfterDel.add(lexeme10);	
		paragraph = pargraph1;
		sentence = sentence4;
		testComposite.add(pargraph1);
		testComposite.add(pargraph2);
		expectedResult.add(sentence2);
		expectedMap.put(lexeme10.toString().toLowerCase(), 2);
	}

	@AfterTest
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
		actualMap = finder.findIdenticalLexemes(testComposite);
		assertEquals(actualMap, expectedMap);
	}
	@Test
	public void testDeleteAllSentencesWithWordLessThan() {
		finder.deleteAllSentencesWithWordLessThan(testComposite, 3);
		TextComponent actualResultAfterDel = testComposite;
		assertEquals(actualResultAfterDel, expectedResultAfterDel);
	}
	@Test(dataProvider = "findNumberOfLettersData")
	public void testFindNumberOfLetters(TextComponent text,LettersType type ,int expected) {
		System.out.println(text);
		int actual = finder.findNumberOfLetters(text, type);
		assertEquals(actual, expected);
	}
	@DataProvider
	public Object[][] findNumberOfLettersData(){
		return new Object[][] {
			{testComposite,LettersType.VOWELS,12},
			{testComposite,LettersType.CONSONANT,18},
			{paragraph,LettersType.VOWELS,2},
			{sentence,LettersType.VOWELS,3}
		};
	}
}
