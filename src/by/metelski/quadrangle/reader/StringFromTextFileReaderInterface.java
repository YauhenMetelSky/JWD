package by.metelski.quadrangle.reader;

import by.metelski.quadrangle.exception.QuadrangleException;

import java.util.List;

public interface StringFromTextFileReaderInterface {
    public List<String> readStringsFromFile(String filePath) throws QuadrangleException;
}
