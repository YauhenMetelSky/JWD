package by.metelski.learn.validation;

import by.metelski.learn.entity.CustomArray;

public class CheckArray {
    public static boolean isArrayValid(CustomArray customArray) {
        if(customArray!=null) {
            int[] array = customArray.getArray();
            return array.length > 0;
        } else {
            return false;
        }
    }
}
