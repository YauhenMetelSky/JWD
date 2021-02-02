package by.metelski.learn.entity;

import by.metelski.learn.exception.CustomArrayException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class CustomArray {
    public final static Logger logger = LogManager.getLogger();
    private int[] array;

    public CustomArray(int[] array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("array equals null");
        }
        this.array = array;
    }

    public int[] getArray() {
        logger.log(Level.INFO, "get array");
        return array.clone();
    }

    public int getArrayElementByIndex(int index) throws CustomArrayException {
        if (index <= array.length - 1 & index >= 0) {
            logger.log(Level.INFO, "get element " + array[index] + " index: " + index);
            return array[index];
        } else {
            throw new CustomArrayException("Index Out of bond");
        }
    }

    public void setArrayElementNyIndex(int index, int element) throws CustomArrayException {
        if (index <= array.length - 1 & index >= 0) {
            array[index] = element;
            logger.log(Level.INFO, "set element " + element + " index: " + index);
        } else {
            throw new CustomArrayException("Index Out of bond");
        }
    }

    public void setArray(int[] array) throws CustomArrayException {
        if (array != null) {
            this.array = array;
            logger.log(Level.INFO, "set array");
        } else {
            throw new CustomArrayException("array equals null");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return "CustomArray{" + Arrays.toString(array) + '}';
    }

}
