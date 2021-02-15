package by.metelski.quadrangle.validate;

import by.metelski.quadrangle.entity.CustomPoint;

import java.util.ArrayList;

public class IsDiagonal {
    public static boolean isPointOneThreeDiagonal(CustomPoint[] points){
        int[] coefficients = findCoefficients(points[0],points[2]);
        ArrayList<Integer> results = new ArrayList<>();
        results.add(calculateEquationStraightLine(coefficients,points[1]));
        results.add(calculateEquationStraightLine(coefficients,points[3]));
        boolean isDiagonal = results.get(0) < 0 && results.get(1) > 0 || results.get(0) > 0 && results.get(1) < 0;
        return isDiagonal;
    }
    private static int calculateEquationStraightLine(int[] coefficients, CustomPoint point) {
        return point.getX() * coefficients[0] + point.getY() * coefficients[1] + coefficients[2];
    }
    private static int[] findCoefficients(CustomPoint pointOne, CustomPoint pointTwo) {
        int[] coefficients = new int[3];
        coefficients[0] = pointOne.getY() - pointTwo.getY();
        coefficients[1] = pointTwo.getX() - pointOne.getX();
        coefficients[2] = pointOne.getX() * pointTwo.getY() - pointTwo.getX() * pointOne.getY();
        return coefficients;
    }
}
