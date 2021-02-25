package by.metelski.compositechain.parser;

import java.util.Arrays;

import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.Leaf;
import by.metelski.compositechain.entity.TextComposite;

public class LeafParser extends AbstractParser {
	private static final String PUNCTUATION_MARK ="[?!.,;:\\-()]";
	
	public LeafParser(AbstractParser nextParser) {
		super(nextParser);
	}

	@Override
	public void parse(String text, TextComposite partComposite) {
		char[] leafs = text.toCharArray();
		for(Character ch: leafs) {
			String str = ch.toString();
		partComposite.add(str.matches(PUNCTUATION_MARK)?new Leaf(ch,ComponentType.PUNCTUATION_MARK):new Leaf(ch,ComponentType.SYMBOL));
		}
		
	}
//	public boolean hasNext() {
//		return false;
//	}

}
