package by.metelski.compositechain.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.metelski.compositechain.entity.ComponentType;
import by.metelski.compositechain.entity.TextComponent;

public class CompositeAction {
	private static final Logger logger = LogManager.getLogger();

	public void deleteAllSentencesWithWordLessThan(TextComponent text, int wordSize) {
		List<TextComponent> sentences;
		List<TextComponent> modificatebleList;
		logger.log(Level.INFO, "word size: " + wordSize + " ,text to handle:\n " + text);
		if (text.getType().compareTo(ComponentType.LEXEME) < -1) {
			for (TextComponent component : text.getComponents()) {
				deleteAllSentencesWithWordLessThan(component, wordSize);
			}
		}
		if (text.getType() == ComponentType.SENTENCE) {
			sentences = text.getComponents();
			modificatebleList = new ArrayList<>(sentences);
			for (TextComponent lexeme : sentences) {
				if (lexeme.countSymbols() < wordSize) {
					modificatebleList.remove(lexeme);
					logger.log(Level.INFO, "lexeme: " + lexeme + " ,removed from text: " + text);
				}
			}
			text.setComponents(modificatebleList);
		}
		logger.log(Level.DEBUG, "text after correction\n" + text);
	}
}
