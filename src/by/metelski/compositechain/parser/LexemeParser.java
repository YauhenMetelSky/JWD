package by.metelski.compositechain.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.TextComposite;

public class LexemeParser extends AbstractParser {
	private static final String LEXEME = "\\S[^.,;:()<>!&?]+";// not correct RegEx
	private AbstractParser nextParser = new SymbolParser();

	@Override
	public void parse(String sentence, TextComposite sentenceComposite) {
		Pattern pattern = Pattern.compile(LEXEME);
		Matcher matcher = pattern.matcher(sentence);
		while (matcher.find()) {
			TextComposite lexemeComposite = new TextComposite(ComponentType.LEXEME);
			sentenceComposite.add(lexemeComposite);
			String word = matcher.group();
			 nextParser.parse(word, lexemeComposite);
		}
	}
}
