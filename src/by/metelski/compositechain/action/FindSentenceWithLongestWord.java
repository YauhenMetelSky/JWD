package by.metelski.compositechain.action;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.metelski.compositechain.comparator.WordByLengthComparator;
import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.TextComponent;

public class FindSentenceWithLongestWord {
	private static final Logger logger = LogManager.getLogger();
	TextComponent sentenceWithLongestWord;
	TextComponent longestWord;

	public TextComponent findSentence(TextComponent text) {
		logger.log(Level.INFO, "Text type: " + text.getType());
		List<TextComponent> components;
		if (text.getType().compareTo(ComponentType.SENTENCE) < -1) {
			for (TextComponent component : text.getComponents()) {
				sentenceWithLongestWord = findSentence(component);
			}
		}	
		if (text.getType() == ComponentType.PARAGRAPH) {
			components = text.getComponents();
			if (sentenceWithLongestWord == null) {
				sentenceWithLongestWord = components.get(0);
				longestWord = sentenceWithLongestWord.getComponents().get(0);
			}
			for (TextComponent component : components) {
				TextComponent tmpLongestWord = Collections.max(component.getComponents(), new WordByLengthComparator());
				if (tmpLongestWord.countSymbols() > longestWord.countSymbols()) {
					sentenceWithLongestWord = component;
					longestWord = tmpLongestWord;
				}
			}
			logger.log(Level.INFO, "sentence with longest word: " + sentenceWithLongestWord +"longest word is: " +longestWord);
		}
		return sentenceWithLongestWord;
	}
}
