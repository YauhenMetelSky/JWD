package by.metelski.compositechain.parser;

import by.metelski.compositechain.entity.impl.TextComposite;

public abstract class AbstractParser {
	private AbstractParser nextParser;
	
	public AbstractParser(AbstractParser nextParser){
		this.nextParser=nextParser;
		}
	public abstract void parse(String part, TextComposite partComposite);
	public AbstractParser getNextParser() {
		return nextParser;
	}
	public boolean hasNext() {
		return nextParser !=null;
	}

}
