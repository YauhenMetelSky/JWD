package by.metelski.quadrangle.repository.impl;

import by.metelski.quadrangle.entity.AbstractShape;
import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.repository.Specification;

public class FindByRangeCoordinate implements Specification {
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    public FindByRangeCoordinate(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    @Override
    public boolean specify(AbstractShape shape) {
        CustomPoint[] points = ((Quadrangle) shape).getPoints();
        boolean result = true;
        for (CustomPoint point : points) {
            if (point.getX() < minX || point.getX() > maxX) {
                result = false;
                break;
            }
            if (point.getY() < minY || point.getY() > maxY) {
                result = false;
                break;
            }
        }
        return result;
    }
}
