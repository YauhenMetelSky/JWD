package by.metelski.quadrangle.validate;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class CheckStringFromFile {
    public final static String PATTERN_POINT = "((-*\\d+,-*\\d)\\s+){3}(-*\\d+,-*\\d)*";
     public final static Logger logger = LogManager.getLogger();

    public static boolean isStringValid(String stringToCheck) {
        boolean isValid = Pattern.matches(PATTERN_POINT, stringToCheck);
        logger.log(Level.INFO, "string is valid : " + isValid);
        return isValid;
    }
}
