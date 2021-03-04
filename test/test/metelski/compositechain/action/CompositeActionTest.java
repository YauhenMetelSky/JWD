package test.metelski.compositechain.action;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.metelski.compositechain.action.CompositeAction;
import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.Symbol;
import by.metelski.compositechain.entity.TextComponent;
import by.metelski.compositechain.entity.TextComposite;

public class CompositeActionTest extends Assert {
	TextComponent testComposite;
	TextComponent expectedResult;
	TextComponent actualResult;
	CompositeAction action;
	@BeforeTest
	public void setUp() {
		action = new CompositeAction();
		TextComponent pargraph1 = new TextComposite(ComponentType.PARAGRAPH);
		TextComponent pargraph2 = new TextComposite(ComponentType.PARAGRAPH);
		TextComponent sentence1 = new TextComposite(ComponentType.SENTENCE);
		TextComponent sentence2 = new TextComposite(ComponentType.SENTENCE);
		TextComponent sentence3 = new TextComposite(ComponentType.SENTENCE);
		TextComponent lexeme1 = new TextComposite(ComponentType.LEXEME);
		TextComponent lexeme2 = new TextComposite(ComponentType.LEXEME);
		TextComponent lexeme3 = new TextComposite(ComponentType.LEXEME);
		TextComponent lexeme4 = new TextComposite(ComponentType.LEXEME);
		TextComponent lexeme5 = new TextComposite(ComponentType.LEXEME);
		TextComponent lexeme6 = new TextComposite(ComponentType.LEXEME);
		TextComponent lexeme7 = new TextComposite(ComponentType.LEXEME);
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
		pargraph2.add(sentence2);
		pargraph2.add(sentence3);
		testComposite.add(pargraph1);
		testComposite.add(pargraph2);
		expectedResult = new TextComposite(ComponentType.TEXT);
		TextComponent expSentence1 = new TextComposite(ComponentType.SENTENCE);
		TextComponent expSentence2= new TextComposite(ComponentType.SENTENCE);
		TextComponent expSentence3= new TextComposite(ComponentType.SENTENCE);
		expSentence1.add(lexeme2);
		expSentence2.add(lexeme3);
		expSentence2.add(lexeme4);
		expSentence3.add(lexeme7);
		TextComponent expParagraph1= new TextComposite(ComponentType.PARAGRAPH);
		TextComponent expParagraph2= new TextComposite(ComponentType.PARAGRAPH);
		expParagraph1.add(expSentence1);
		expParagraph2.add(expSentence2);
		expParagraph2.add(expSentence3);
		expectedResult.add(expParagraph1);
		expectedResult.add(expParagraph2);
	}
	@Test
	public void testDeleteAllSentencesWithWordLessThan() {
		action.deleteAllSentencesWithWordLessThan(testComposite, 3);
		actualResult = testComposite;
		assertEquals(actualResult, expectedResult);
	}
}
