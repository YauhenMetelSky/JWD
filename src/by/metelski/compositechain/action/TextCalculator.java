package by.metelski.compositechain.action;

import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.TextComponent;
import by.metelski.compositechain.entity.TextComposite;

public class TextCalculator {

	public int findNumberOf(ComponentType type, TextComponent text) {
		int counter = 0;
		
		TextComposite tmpComponent;
		TextComposite tmpText = (TextComposite) text;
		
		if(ComponentType.SYMBOL==type) {
			return tmpText.countSymbols();
		}
	
		for (TextComponent component : tmpText.getComponents()) {
			tmpComponent = (TextComposite) component;
			
             if(tmpComponent.getType().compareTo(type) == 0)  {
            	 counter++;
             }
			if (tmpComponent.getType().compareTo(type) < -1) {
				counter += findNumberOf(type, tmpComponent);
			} else {
				for (TextComponent nextLevelComponent : tmpComponent.getComponents()) {
					TextComposite composite = (TextComposite) nextLevelComponent;
					if (composite.getType() == (type)) {
						counter++;
					}
				}
			}
		}
		return counter;
	}
}
