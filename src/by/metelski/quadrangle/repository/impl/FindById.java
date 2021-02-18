package by.metelski.quadrangle.repository.impl;

import by.metelski.quadrangle.entity.AbstractShape;
import by.metelski.quadrangle.repository.Specification;

public class FindById implements Specification {
    private long id;
    public FindById(long id) {
    }

    @Override
    public boolean specify(AbstractShape abstractShape) {
        boolean result = abstractShape.getId()==id;
        return result;
    }
}
