package by.metelski.compositechain.comparator;

import java.util.Comparator;

import by.metelski.compositechain.action.TextCalculator;
import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.TextComposite;

public class TextBySentencesNumberComparator implements Comparator<TextComposite> {
private TextCalculator calculator;
	
	@Override
	public int compare(TextComposite o1, TextComposite o2) {
	calculator = new TextCalculator();
	int sentencesNumberO1 =calculator.findNumberOf(ComponentType.SENTENCE, o1);
	int centencesNumberO2 =calculator.findNumberOf(ComponentType.SENTENCE, o2);
	
		return sentencesNumberO1-centencesNumberO2;
	}


}
