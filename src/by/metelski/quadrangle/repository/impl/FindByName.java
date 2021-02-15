package by.metelski.quadrangle.repository.impl;

import by.metelski.quadrangle.entity.CustomShape;
import by.metelski.quadrangle.repository.Specification;

public class FindByName implements Specification {
    private String name;
    public FindByName(String name) {
    }

    @Override
    public boolean specify(CustomShape customShape) {
        boolean result = customShape.getName().equals(name);
        return result;
    }
}
