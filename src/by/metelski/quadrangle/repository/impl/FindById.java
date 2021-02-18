package by.metelski.quadrangle.repository.impl;

import by.metelski.quadrangle.entity.AbstractShape;
import by.metelski.quadrangle.repository.Specification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindById implements Specification {
    private long id;
    public FindById(long id) {
        this.id = id;

    }

    @Override
    public boolean specify(AbstractShape abstractShape) {
        boolean result = abstractShape.getId()==id;
        return result;
    }
}
