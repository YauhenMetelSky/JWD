package by.metelski.compositechain.parser;

import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.TextComposite;

public class SentenceParser extends AbstractParser {
	private static final String SENTENCE_REGEX = "(?<=([!?.{1,3}]\s))";
	private AbstractParser nextParser = new LexemeParser();
	@Override
	public void parse(String paragraph, TextComposite textComposite) {
		String[] sentences = paragraph.split(SENTENCE_REGEX);
		for(String sentence: sentences) {
			TextComposite sentenceComposite = new TextComposite(ComponentType.SENTENCE);
			textComposite.add(sentenceComposite);
			nextParser.parse(sentence,sentenceComposite);
		}
	}
}
