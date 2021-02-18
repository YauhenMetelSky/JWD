package by.metelski.quadrangle.factory;

import by.metelski.quadrangle.entity.AbstractShape;
import by.metelski.quadrangle.entity.CustomPoint;

public interface ShapeFactoryInterface {
    AbstractShape createShape(CustomPoint[] points);
 }
