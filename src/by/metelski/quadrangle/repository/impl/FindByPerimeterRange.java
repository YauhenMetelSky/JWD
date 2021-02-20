package by.metelski.quadrangle.repository.impl;

import by.metelski.quadrangle.action.impl.QuadrangleCalculator;
import by.metelski.quadrangle.entity.AbstractShape;
import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.repository.Specification;

public class FindByPerimeterRange implements Specification {
    private double minPerimeter;
    private double maxPerimeter;

    public FindByPerimeterRange(double minPerimeter, double maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    public boolean specify(AbstractShape abstractShape) {
        QuadrangleCalculator calculator = new QuadrangleCalculator();
        double perimeter = calculator.findPerimeter((Quadrangle) abstractShape);
        return minPerimeter < perimeter && perimeter < maxPerimeter;
    }
}
