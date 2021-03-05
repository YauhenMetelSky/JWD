package by.metelski.compositechain.reader.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.metelski.compositechain.exception.CompositeException;
import by.metelski.compositechain.reader.StringFromFileReaderInterface;

public class StringFromFileTextReader implements StringFromFileReaderInterface {
    public final static Logger logger = LogManager.getLogger();

    public String readStringsFromFile(String filePath) throws CompositeException {
        String stringsFromFile;
        if(filePath==null) {
        	throw new CompositeException("filePath in method arguments is null");
        }
        try {
        	stringsFromFile = Files.lines(Paths.get(filePath)).collect(Collectors.joining());
        } catch (IOException e) {
        	e.printStackTrace();
            throw new CompositeException("File input exception",e);      	
        }
        logger.log(Level.INFO,"read text from file : " + stringsFromFile );
        return stringsFromFile;
    }
}
