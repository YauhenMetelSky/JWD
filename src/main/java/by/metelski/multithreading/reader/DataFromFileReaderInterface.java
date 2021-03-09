package by.metelski.multithreading.reader;

import java.util.List;
import by.metelski.multithreading.exception.FerryException;

public interface DataFromFileReaderInterface {
	public List<String> readStringsFromFile(String filePath) throws FerryException;
}
