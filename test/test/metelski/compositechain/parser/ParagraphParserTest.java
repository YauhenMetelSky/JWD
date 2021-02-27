package test.metelski.compositechain.parser;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.Symbol;
import by.metelski.compositechain.entity.TextComposite;
import by.metelski.compositechain.parser.ParagraphParser;
import by.metelski.compositechain.parser.SentenceParser;

public class ParagraphParserTest extends Assert {
	TextComposite expectedResult;
	TextComposite actualResult;
	ParagraphParser parser;
	String testText;

	@BeforeTest
	public void setUp() {
		parser = new ParagraphParser();
		TextComposite pargraph1 = new TextComposite(ComponentType.PARAGRAF);
		TextComposite pargraph2 = new TextComposite(ComponentType.PARAGRAF);
		TextComposite sentence1 = new TextComposite(ComponentType.SENTENCE);
		TextComposite sentence2 = new TextComposite(ComponentType.SENTENCE);
		TextComposite sentence3 = new TextComposite(ComponentType.SENTENCE);
		TextComposite lexeme1 = new TextComposite(ComponentType.LEXEME);
		TextComposite lexeme2 = new TextComposite(ComponentType.LEXEME);
		TextComposite lexeme3 = new TextComposite(ComponentType.LEXEME);
		TextComposite lexeme4 = new TextComposite(ComponentType.LEXEME);
		TextComposite lexeme5 = new TextComposite(ComponentType.LEXEME);
		TextComposite lexeme6 = new TextComposite(ComponentType.LEXEME);
		TextComposite lexeme7 = new TextComposite(ComponentType.LEXEME);
		testText = "    My cat. Name -Fenix! \tIs he fat?";
		expectedResult = new TextComposite();
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
		sentence1.add(lexeme1);
		sentence1.add(lexeme2);
		sentence2.add(lexeme3);
		sentence2.add(lexeme4);
		sentence3.add(lexeme5);
		sentence3.add(lexeme6);
		sentence3.add(lexeme7);
		pargraph1.add(sentence1);
		pargraph1.add(sentence2);
		pargraph2.add(sentence3);
		expectedResult.add(pargraph1);
		expectedResult.add(pargraph2);
	}

	@Test
	public void testParse() {
		actualResult = new TextComposite();
		parser.parse(testText, actualResult);
		assertEquals(actualResult, expectedResult);
	}

}
