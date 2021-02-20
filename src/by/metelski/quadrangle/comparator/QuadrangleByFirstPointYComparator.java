package by.metelski.quadrangle.comparator;

import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.Quadrangle;
import java.util.Comparator;

public class QuadrangleByFirstPointYComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        CustomPoint pointA1 = o1.getPointA();
        CustomPoint pointA2 = o2.getPointA();
        return pointA1.getY() - pointA2.getY();
    }
}
