package by.metelski.quadrangle.repository.impl;

import by.metelski.quadrangle.entity.AbstractShape;
import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.repository.Specification;

public class FindByPoint implements Specification {
    private CustomPoint point;

    public FindByPoint(CustomPoint point) {
        this.point = point;
    }

    @Override
    public boolean specify(AbstractShape abstractShape) {
        boolean result = false;
        for (CustomPoint pointFromShape:((Quadrangle)abstractShape).getPoints()) {
            if (point.equals(pointFromShape)){
                result=true;
                break;
            }
        }
        return result;
    }
}
