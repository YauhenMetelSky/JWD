package by.metelski.quadrangle.repository;

import by.metelski.quadrangle.entity.CustomShape;

public interface Specification {
    boolean specify(CustomShape customShape);
}
