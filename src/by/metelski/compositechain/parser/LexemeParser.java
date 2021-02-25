package by.metelski.compositechain.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.impl.TextComposite;

public class LexemeParser extends AbstractParser {
	private static final String LEXEME = "[\\w\\p{Punct}А-Яа-я“”]+";

	public LexemeParser(AbstractParser nextParser) {
		super(nextParser);
	}
	
	@Override
	public void parse(String sentence, TextComposite sentenceComposite) {
		Pattern pattern = Pattern.compile(LEXEME);
		Matcher matcher = pattern.matcher(sentence);
		while (matcher.find()) {
			TextComposite lexemeComposite = new TextComposite(ComponentType.WORD);
			sentenceComposite.add(lexemeComposite);
			AbstractParser nextParser = super.getNextParser();
			String word = matcher.group();
			nextParser.parse(word, lexemeComposite);
		}
	}
}
