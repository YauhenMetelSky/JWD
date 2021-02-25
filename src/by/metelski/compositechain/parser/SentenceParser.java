package by.metelski.compositechain.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.impl.TextComposite;

public class SentenceParser extends AbstractParser {
	private static final String SENTENCE = "([A-Z0-9])(([\\w\\s]|[\\p{Punct}А-Яа-я“”](?!\\s[A-Z0-9]))+)([?!.])";

	public SentenceParser(AbstractParser nextParser) {
		super(nextParser);
	}

	@Override
	public void parse(String paragraph, TextComposite paragraphComposite) {
		Pattern pattern = Pattern.compile(SENTENCE);
		Matcher matcher = pattern.matcher(paragraph);
		while (matcher.find()) {
			TextComposite sentenceComposite = new TextComposite(ComponentType.SENTENCE);
			paragraphComposite.add(sentenceComposite);
			AbstractParser nextParser = super.getNextParser();
			String sentence = matcher.group();
			nextParser.parse(sentence, sentenceComposite);
		}
	}
}
