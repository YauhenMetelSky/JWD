package by.metelski.compositechain.action;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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

	public Map<String, Integer> findIdenticalWords(TextComponent text) {
		Map<String, Integer> identicalWords = new HashMap<>();		
		identicalWords = fillWordsMap(text, identicalWords);
		logger.log(Level.INFO, "identical words before removing: " + Arrays.asList(identicalWords));
		removeAllSingleWords(identicalWords);
		logger.log(Level.INFO, "identical words: " + Arrays.asList(identicalWords));
		return identicalWords;
	}

	private void removeAllSingleWords(Map<String, Integer> identicalWords) {
		Iterator<Map.Entry<String, Integer>> iterator = identicalWords.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> keyValueObject = iterator.next();
			Integer counter = keyValueObject.getValue();
			if (counter < 2) {
				iterator.remove();
			}
		}
	}

	private Map<String, Integer> fillWordsMap(TextComponent text, Map<String, Integer> identicalWords) {
		if (text.getType().compareTo(ComponentType.LEXEME) < -1) {
			for (TextComponent component : text.getComponents()) {
				identicalWords = fillWordsMap(component, identicalWords);
			}
		}
		if (text.getType().compareTo(ComponentType.LEXEME) == -1) {
			extracted(text, identicalWords);
		}
		return identicalWords;
	}
//TODO rename
	private void extracted(TextComponent text, Map<String, Integer> identicalWords) {
		for (TextComponent component : text.getComponents()) {
			String lexeme = component.toString().toLowerCase();
			if (identicalWords.containsKey(lexeme)) {
				int counterValue = identicalWords.get(lexeme);
				identicalWords.put(lexeme, ++counterValue);
			} else {
				identicalWords.put(lexeme, 1);
			}
		}
	}
}
