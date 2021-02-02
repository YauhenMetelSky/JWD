package by.metelski.learn.creator;

import by.metelski.learn.entity.CustomArray;
import by.metelski.learn.exception.CustomArrayException;
import by.metelski.learn.parser.CustomParser;
import by.metelski.learn.reader.StringFromTextFileReader;
import by.metelski.learn.validation.CheckStringFromFile;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayCreator {
    public final static Logger logger = LogManager.getLogger();

    public List<CustomArray> createCustomArraysFromFile(String filePath) throws CustomArrayException {
        List<CustomArray> customArrayList = new ArrayList<>();
        CustomParser customParser = new CustomParser();
        StringFromTextFileReader reader = new StringFromTextFileReader();
        List<String> stringsFromFile = reader.readStringsFromFile(filePath);
        for (String string : stringsFromFile) {
            if (CheckStringFromFile.isStringValid(string)) {
                int[] tmpArray = customParser.parseArrayFromString(string);
                CustomArray customArray = new CustomArray(tmpArray);
                customArrayList.add(customArray);
                logger.log(Level.INFO, "created CustomArray object, " + customArray.toString()+" and added to CustomArrayList");
            }
        }
        logger.log(Level.INFO, "return CustomArrayList");
        return customArrayList;
    }
}
