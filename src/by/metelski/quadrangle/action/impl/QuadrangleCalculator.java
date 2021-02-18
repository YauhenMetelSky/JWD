package by.metelski.quadrangle.action.impl;

import by.metelski.quadrangle.action.ShapeCalculator;
import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.Quadrangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class QuadrangleCalculator implements ShapeCalculator {
    public static final Logger logger = LogManager.getLogger();

    @Override
    public double findArea(Quadrangle quadrangle) {
        double[] diagonals = findDiagonalsLength(quadrangle);
        double square = 0.5 * diagonals[0] * diagonals[1] * Math.sin(findAngleBetweenDiagonals(quadrangle));
        logger.log(Level.INFO, "square is " + square);
        return square;
    }

    @Override
    public double findPerimeter(Quadrangle quadrangle) {
        double perimeter = Arrays.stream(findSides(quadrangle))
                .sum();
        findAngleBetweenDiagonals(quadrangle);
        logger.log(Level.INFO, "perimeter is " + perimeter);
        return perimeter;
    }

    public double[] findDiagonalsLength(Quadrangle quadrangle) {
        double[] diagonalsLength = new double[2];
        CustomPoint[] points = quadrangle.getPoints();
        for (int i = 0; i < 2; i++) {
            diagonalsLength[i] = findSegmentLength(points[i], points[i + 2]);
            logger.log(Level.INFO, "diagonal: " + i + " length: " + diagonalsLength[i]);
        }
        return diagonalsLength;
    }

    private double findAngleBetweenDiagonals(Quadrangle quadrangle) {
        double[] diagonals = findDiagonalsLength(quadrangle);
        CustomPoint[] points = quadrangle.getPoints();
        double angle;
        double ax;
        double ay;
        double bx;
        double by;
        ax = points[2].getX() - points[0].getX();
        ay = points[2].getY() - points[0].getY();
        bx = points[3].getX() - points[1].getX();
        by = points[3].getY() - points[1].getY();
        double multiplicationVectorsResult = ax * bx + ay * by;
        angle = Math.acos(multiplicationVectorsResult / (diagonals[0] * diagonals[1]));
        logger.log(Level.INFO, " angle between diagonals: " + angle);
        return angle;
    }

    public double[] findSides(Quadrangle quadrangle) {
        double[] sides = new double[4];
        CustomPoint[] points = quadrangle.getPoints();
        for (int i = 0; i < 4; i++) {
            if (i <= 2) {
                sides[i] = findSegmentLength(points[i], points[i + 1]);
            } else {
                sides[i] = findSegmentLength(points[i], points[i - 3]);
            }
            logger.log(Level.INFO, "side: " + i + " length: " + sides[i]);
        }
        return sides;
    }

    private double findSegmentLength(CustomPoint pointOne, CustomPoint pointTwo) {
        double side = Math.hypot(pointOne.getX() - pointTwo.getX(), pointOne.getY() - pointTwo.getY());
        return side;
    }
}
