package by.metelski.quadrangle.comparator;

import by.metelski.quadrangle.action.ShapeCalculator;
import by.metelski.quadrangle.action.impl.QuadrangleCalculator;
import by.metelski.quadrangle.entity.Quadrangle;
import java.util.Comparator;

public class QuadrangleByAreaComparator implements Comparator<Quadrangle> {
    ShapeCalculator calculator;

    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        calculator = new QuadrangleCalculator();
        double areaO1 = calculator.findArea(o1);
        double areaO2 = calculator.findArea(o2);
        int result = Double.compare(areaO1, areaO2);
        return result;
    }
}
