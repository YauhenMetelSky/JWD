package by.metelski.quadrangle.comparator;

import by.metelski.quadrangle.entity.Quadrangle;
import java.util.Comparator;

public class QuadrangleByIdComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        int result = Long.compare(o1.getId(), o2.getId());
        return result;
    }
}
