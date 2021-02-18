package by.metelski.quadrangle.repository.impl;

import by.metelski.quadrangle.action.impl.QuadrangleCalculator;
import by.metelski.quadrangle.entity.AbstractShape;
import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.repository.Specification;

public class FindByAreaRange implements Specification {
    private double minArea;
    private double maxArea;

    public FindByAreaRange(double minArea,double maxArea){
        this.minArea=minArea;
        this.maxArea=maxArea;
    }

    @Override
    public boolean specify(AbstractShape abstractShape) {
        boolean result;
        QuadrangleCalculator calculator = new QuadrangleCalculator();
        double area = calculator.findArea((Quadrangle) abstractShape);
        return minArea<area&&area<maxArea;
    }
}
