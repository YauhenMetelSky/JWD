package by.metelski.compositechain.comparator;

import java.util.Comparator;

import by.metelski.compositechain.action.TextCalculator;
import by.metelski.compositechain.entity.TextComposite;

public class TextByParagraphsNumberComparator implements Comparator<TextComposite> {
	private TextCalculator calculator;

	@Override
	public int compare(TextComposite o1, TextComposite o2) {
	calculator = new TextCalculator();
	
		return ;
	}

}
