package by.metelski.compositechain.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.TextComposite;

public class ParagrafParser extends AbstractParser {
	private static final String PARAGRAPH = "\t[A-Z][^\\t]+";

	public ParagrafParser(AbstractParser nextParser) {
		super(nextParser);
	}

	@Override
	public void parse(String text, TextComposite textComposite) {
		Pattern pattern = Pattern.compile(PARAGRAPH);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			TextComposite paragraphComposite = new TextComposite(ComponentType.PARAGRAF);
			textComposite.add(paragraphComposite);
			AbstractParser nextParser = super.getNextParser();
			String paragraph = matcher.group();
			nextParser.parse(paragraph, paragraphComposite);
		}
	}
}
