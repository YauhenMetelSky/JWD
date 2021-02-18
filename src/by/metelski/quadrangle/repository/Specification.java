package by.metelski.quadrangle.repository;

import by.metelski.quadrangle.entity.AbstractShape;

public interface Specification {
    boolean specify(AbstractShape abstractShape);
}
