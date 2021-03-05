package by.metelski.compositechain.action;

import java.util.ArrayList;
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
	
	public List<TextComponent> findSentenceWithLongestWord(TextComponent text) {
		List<TextComponent> sentencesWithLongestLexeme = new ArrayList<>();
		List<TextComponent> components = findComponentsByType(text, ComponentType.SENTENCE);
		TextComponent longestLexeme = findLongestLexeme(components);
		logger.log(Level.INFO, "longest lexeme: " + longestLexeme);
		sentencesWithLongestLexeme = fillSentencesListWithLongestLexeme(components, longestLexeme);
		logger.log(Level.INFO, "sentences with longest lexemes: " + sentencesWithLongestLexeme);
		return sentencesWithLongestLexeme;
	}

	public Map<String, Integer> findIdenticalLexemes(TextComponent text) {
		List<TextComponent> lexemes = findComponentsByType(text, ComponentType.LEXEME);
		Map<String, Integer> identicalLexemes = fillLexemesMap(lexemes);
		logger.log(Level.INFO, "identical lexemes before removing: " + Arrays.asList(identicalLexemes));
		removeAllSingleWords(identicalLexemes);
		logger.log(Level.INFO, "identical lexemes: " + Arrays.asList(identicalLexemes));
		return identicalLexemes;
	}

	private Map<String, Integer> fillLexemesMap(List<TextComponent> lexemes) {
		Map<String, Integer> identicalLexemes = new HashMap<>();
		for (TextComponent component : lexemes) {
			String lexeme = component.toString().toLowerCase();
			if (identicalLexemes.containsKey(lexeme)) {
				int counterValue = identicalLexemes.get(lexeme);
				identicalLexemes.put(lexeme, ++counterValue);
			} else {
				identicalLexemes.put(lexeme, 1);
			}
		}
		return identicalLexemes;
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

	private List<TextComponent> fillSentencesListWithLongestLexeme(List<TextComponent> components,
			TextComponent longestLexeme) {
		List<TextComponent> sentencesWithLongestLexeme = new ArrayList<>();
		for (TextComponent sentence : components) {
			if (sentence.getComponents().contains(longestLexeme)) {
				sentencesWithLongestLexeme.add(sentence);
			}
		}
		return sentencesWithLongestLexeme;
	}

	private TextComponent findLongestLexeme(List<TextComponent> components) {
		TextComponent longestLexeme = components.get(0).getComponents().get(0);
		for (TextComponent component : components) {
			TextComponent tmpLongestLexeme = Collections.max(component.getComponents(), new WordByLengthComparator());
			if (tmpLongestLexeme.countSymbols() > longestLexeme.countSymbols()) {
				longestLexeme = tmpLongestLexeme;
			}
		}
		return longestLexeme;
	}

	private List<TextComponent> findComponentsByType(TextComponent text, ComponentType type) {
		List<TextComponent> sentences = new ArrayList<>();
		if (text.getType().compareTo(type) < 0) {
			for (TextComponent component : text.getComponents()) {
				sentences.addAll(findComponentsByType(component, type));
			}
		}
		if (text.getType().compareTo(type) == 0) {
			sentences.add(text);
		}
		return sentences;
	}
}
