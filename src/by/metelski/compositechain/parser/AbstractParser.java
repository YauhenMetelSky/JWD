package by.metelski.compositechain.parser;

import by.metelski.compositechain.entity.TextComposite;

public abstract class AbstractParser {
	public abstract void parse(String text, TextComposite partComposite);
}
