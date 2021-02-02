package by.metelski.learn.action;

import by.metelski.learn.entity.CustomArray;
import by.metelski.learn.exception.CustomArrayException;
import java.util.Arrays;

public class ArraySortStream {
    public void sortCustomArray(CustomArray customArray) throws CustomArrayException {
        int[] array = Arrays.stream(customArray.getArray())
                .sorted()
                .toArray();
        customArray.setArray(array);
    }
}
