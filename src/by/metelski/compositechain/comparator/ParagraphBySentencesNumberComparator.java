package by.metelski.compositechain.comparator;

import java.util.Comparator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.metelski.compositechain.entity.TextComponent;

public class ParagraphBySentencesNumberComparator implements Comparator<TextComponent> {
	private static final Logger logger = LogManager.getLogger();
	
	@Override
	public int compare(TextComponent paragraph1, TextComponent paragraph2) {		
		int sentencesNumberParagraph1 =paragraph1.getComponents().size(); 
		logger.log(Level.DEBUG, "number of sentences first object: " + sentencesNumberParagraph1);
		int sentencesNumberParagraph2 = paragraph2.getComponents().size();
		logger.log(Level.DEBUG, "number of sentences second object: " + sentencesNumberParagraph2);
		return sentencesNumberParagraph1 - sentencesNumberParagraph2;
	}
}
