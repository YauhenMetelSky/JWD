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
        double[]diagonals = findDiagonals(quadrangle);
        double square = 0.5 *diagonals[0]*diagonals[1]*Math.sin(findAngleBetweenDiagonals(quadrangle));
        logger.log(Level.INFO, "square is " + square);
        return square;
    }

    public double findPerimeter(Quadrangle quadrangle) {
        double perimeter = Arrays.stream(findSides(quadrangle))
                .sum();
        findAngleBetweenDiagonals(quadrangle);
        logger.log(Level.INFO, "perimeter is " + perimeter);
        return perimeter;
    }

    public double[] findDiagonals(Quadrangle quadrangle) {
        double[] diagonals = new double[2];
        CustomPoint[] points = quadrangle.getPoints();
        for (int i = 0; i < 2; i++) {
            diagonals[i] = findSide(points[i], points[i + 2]);
            logger.log(Level.INFO, "position: " + i + " find side " + diagonals[i]);
        }
        return diagonals;
    }

    private double findAngleBetweenDiagonals(Quadrangle quadrangle) {
        double[] diagonals = findDiagonals(quadrangle);
        CustomPoint[] points = quadrangle.getPoints();
        double angle;
        double ax;
        double ay;
        double bx;
        double by;
        ax = points[2].getxCoordinate() - points[0].getxCoordinate();
        ay = points[2].getyCoordinate() - points[0].getyCoordinate();
        bx = points[3].getxCoordinate() - points[1].getxCoordinate();
        by = points[3].getyCoordinate() - points[1].getyCoordinate();
        double multiplicationVectorsResult = ax * bx + ay * by;
        angle =Math.acos(multiplicationVectorsResult / (diagonals[0] * diagonals[1]));
        logger.log(Level.INFO, " angle: " + angle);
        return angle;
    }

    public double[] findSides(Quadrangle quadrangle) {
        double[] sides = new double[4];
        CustomPoint[] points = quadrangle.getPoints();
        for (int i = 0; i < 4; i++) {
            if (i <= 2) {
                sides[i] = findSide(points[i], points[i + 1]);
            } else {
                sides[i] = findSide(points[i], points[i - 3]);
            }
            logger.log(Level.INFO, "position: " + i + " find side " + sides[i]);
        }
        return sides;
    }

    private double findSide(CustomPoint pointOne, CustomPoint pointTwo) {
        double side = Math.hypot(pointOne.getxCoordinate() - pointTwo.getxCoordinate(), pointOne.getyCoordinate() - pointTwo.getyCoordinate());
        return side;
    }
}
