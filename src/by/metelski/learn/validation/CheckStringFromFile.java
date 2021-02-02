package by.metelski.learn.validation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.regex.Pattern;

public class CheckStringFromFile {
    public final static String PATTERN_ARRAY = "(-*\\d+[\\,\\s]*)+";
    public final static Logger logger = LogManager.getLogger();

    public static boolean isStringValid(String stringToCheck) {
        boolean isValid = Pattern.matches(PATTERN_ARRAY, stringToCheck);
        logger.log(Level.INFO, "string is valid : " + isValid);
        return isValid;
    }
}
