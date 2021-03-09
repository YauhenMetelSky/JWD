package by.metelski.multithreading.reader.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.metelski.multithreading.exception.FerryException;
import by.metelski.multithreading.reader.DataFromFileReaderInterface;

public class DataFromFileReader implements DataFromFileReaderInterface {
	public final static Logger logger = LogManager.getLogger();

	@Override
    public List<String> readStringsFromFile(String filePath) throws FerryException {
        List<String> stringsFromFile=null;
        if(filePath==null) {
        	throw new FerryException("filePath in method arguments is null");
        }
         Path path = Paths.get(filePath);
        if(Files.notExists(path)||Files.isDirectory(path)||!Files.isReadable(path)) {
        	throw new FerryException("invalide file or path to file");
        }
        try {
        	Stream<String>linesStream = Files.lines(path);
        	stringsFromFile = linesStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new FerryException("File input exception",e);
        }
        logger.log(Level.INFO,"read string from file : " + stringsFromFile );
        return stringsFromFile;
    }
}
