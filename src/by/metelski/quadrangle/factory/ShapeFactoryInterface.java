package by.metelski.quadrangle.factory;

import by.metelski.quadrangle.entity.AbstractShape;
import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.exception.QuadrangleException;

public interface ShapeFactoryInterface {
    AbstractShape createShape(CustomPoint[] points) throws QuadrangleException;
 }
