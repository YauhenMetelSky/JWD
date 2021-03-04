package by.metelski.compositechain.action;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.metelski.compositechain.comparator.WordByLengthComparator;
import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.TextComponent;

public class FindComponent {
	private static final Logger logger = LogManager.getLogger();
	TextComponent sentenceWithLongestWord;
	TextComponent longestWord;

	public TextComponent findSentenceWithLongestWord(TextComponent text) {
		logger.log(Level.INFO, "Text type: " + text.getType());
		List<TextComponent> components;
		if (text.getType().compareTo(ComponentType.SENTENCE) < -1) {
			for (TextComponent component : text.getComponents()) {
				sentenceWithLongestWord = findSentenceWithLongestWord(component);
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
			logger.log(Level.INFO,
					"sentence with longest word: " + sentenceWithLongestWord + "longest word is: " + longestWord);
		}
		return sentenceWithLongestWord;
	}

	public Map<TextComponent, Integer> findIdenticalWords(TextComponent text) {
		Map<TextComponent, Integer> identicalWords = new HashMap<>();
		if (text.getType().compareTo(ComponentType.LEXEME) < -1) {
			for (TextComponent component : text.getComponents()) {
				identicalWords = findIdenticalWords(component);
			}
		}
		for(TextComponent component : text.getComponents()) {
			String lexeme = component.toString().toLowerCase();
			
			
		}

		// TODO realization,return result
		return null;
	}
}
