package by.metelski.quadrangle.validate;

import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.Quadrangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CreateValidator {
    public static final Logger logger = LogManager.getLogger();

    public static boolean isPossibleCreate(CustomPoint[]points){
             boolean result = false;
             double[] sides = findSides(points);
             double sum = Arrays.stream(sides)
                     .sum();
        for (int i = 0; i <sides.length ; i++) {
            if(sides[i]<sum-sides[i]){
                result = true;
                break;
            }
        }
        logger.log(Level.INFO,"possible to create: " + result);
        return result;
    }
    private static double[] findSides(CustomPoint[] points) {
        double[] sides = new double[4];
        for (int i = 0; i < 4; i++) {
            if (i <= 2) {
                sides[i] = findSegmentLength(points[i], points[i + 1]);
            } else {
                sides[i] = findSegmentLength(points[i], points[i - 3]);
            }
        }
        return sides;
    }
    private static double findSegmentLength(CustomPoint pointOne, CustomPoint pointTwo) {
        double side = Math.hypot(pointOne.getX() - pointTwo.getX(), pointOne.getY() - pointTwo.getY());
        return side;
    }
}
