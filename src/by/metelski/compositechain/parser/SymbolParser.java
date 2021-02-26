package by.metelski.compositechain.parser;

import java.util.Arrays;

import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.Symbol;
import by.metelski.compositechain.entity.TextComposite;

public class SymbolParser extends AbstractParser {
	private static final String PUNCTUATION_MARK_REGEX ="[?!.,;:\\-()]";

	@Override
	public void parse(String text, TextComposite textComposite) {
		char[] symbols = text.toCharArray();
		for(Character ch: symbols) {
			String str = ch.toString();
			if(!str.equals(" ")) {
		textComposite.add(str.matches(PUNCTUATION_MARK_REGEX)?new Symbol(ch,ComponentType.PUNCTUATION_MARK):new Symbol(ch,ComponentType.SYMBOL));
		}
		}
		
	}

}
