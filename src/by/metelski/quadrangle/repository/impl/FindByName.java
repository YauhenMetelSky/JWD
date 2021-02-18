package by.metelski.quadrangle.repository.impl;

import by.metelski.quadrangle.entity.AbstractShape;
import by.metelski.quadrangle.repository.Specification;

public class FindByName implements Specification {
    private String name;
    public FindByName(String name) {
    }

    @Override
    public boolean specify(AbstractShape abstractShape) {
        boolean result = abstractShape.getName().equals(name);
        return result;
    }
}
