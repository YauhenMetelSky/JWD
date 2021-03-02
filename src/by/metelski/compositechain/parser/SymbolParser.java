package by.metelski.compositechain.parser;

import java.util.Arrays;
import java.util.stream.Stream;

import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.Symbol;
import by.metelski.compositechain.entity.TextComponent;
import by.metelski.compositechain.entity.TextComposite;

public class SymbolParser extends AbstractParser {
	private static final String PUNCTUATION_MARK_REGEX = "\\p{Punct}";
	private static final String BLANK_REGEX = " ";
	@Override
	public void parse(String text, TextComposite textComposite) {
		TextComponent symbol;
		char[] symbols = text.toCharArray();
		for (Character ch : symbols) {
			String str = ch.toString();
			if (!str.matches(BLANK_REGEX)) {
				if (str.matches(PUNCTUATION_MARK_REGEX)) {
					symbol = new Symbol(ch, ComponentType.PUNCTUATION_MARK);
				} else {
					symbol = new Symbol(ch, ComponentType.SYMBOL);
				}
				textComposite.add(symbol);
			}
		}
	}
}
