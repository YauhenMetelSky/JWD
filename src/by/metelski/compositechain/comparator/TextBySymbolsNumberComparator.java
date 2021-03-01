package by.metelski.compositechain.comparator;

import java.util.Comparator;

import by.metelski.compositechain.action.TextCalculator;
import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.TextComponent;
import by.metelski.compositechain.entity.TextComposite;

public class TextBySymbolsNumberComparator implements Comparator<TextComposite> {

private TextCalculator calculator;
	
	@Override
	public int compare(TextComposite o1, TextComposite o2) {
	calculator = new TextCalculator();
	int symbolsNumberO1 =calculator.findNumberOf(ComponentType.SYMBOL, o1);
	int symbolsNumberO2 =calculator.findNumberOf(ComponentType.SYMBOL, o2);
	
		return symbolsNumberO1-symbolsNumberO2;
	}

}
