package by.metelski.compositechain.action;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.TextComponent;
import by.metelski.compositechain.entity.TextComposite;

public class TextCalculator {
	private static final Logger logger = LogManager.getLogger();

	public int findNumberOf(ComponentType type, TextComponent text) {
		int counter = 0;
		TextComposite tmpComponent;
		TextComposite tmpText = (TextComposite) text;
		if (ComponentType.SYMBOL == type) {
			counter = tmpText.countSymbols();
			logger.log(Level.INFO, "number of: " + type + " is: " + counter);
			return counter;
		}
		for (TextComponent component : tmpText.getComponents()) {
			tmpComponent = (TextComposite) component;
			if (tmpComponent.getType().compareTo(type) == 0) {
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
		logger.log(Level.INFO, "number of: " + type + " is: " + counter);
		return counter;
	}
}
