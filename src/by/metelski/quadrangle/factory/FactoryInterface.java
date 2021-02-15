package by.metelski.quadrangle.factory;

import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.CustomShape;

public interface FactoryInterface {
    CustomShape createShape(String name,CustomPoint...point);
   // CustomShape createShape(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC, CustomPoint pointD, String name);
}
