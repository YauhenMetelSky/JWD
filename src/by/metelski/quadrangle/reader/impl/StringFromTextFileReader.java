package by.metelski.quadrangle.reader.impl;

import by.metelski.quadrangle.exception.QuadrangleException;
import by.metelski.quadrangle.reader.StringFromTextFileReaderInterface;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class StringFromTextFileReader implements StringFromTextFileReaderInterface {
    public final static Logger logger = LogManager.getLogger();

    public List<String> readStringsFromFile(String filePath) throws QuadrangleException {
        List<String> stringsFromFile;
        try {
            stringsFromFile= Files.lines(Paths.get(filePath))
                                  .collect(Collectors.toList());
        } catch (IOException e) {
            throw new QuadrangleException("File input exception",e);
        }
        logger.log(Level.INFO,"read string from file : " + stringsFromFile );
        return stringsFromFile;
    }
}
