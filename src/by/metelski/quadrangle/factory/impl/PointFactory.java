package by.metelski.quadrangle.factory.impl;

import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.factory.PointFactoryInterface;

public class PointFactory implements PointFactoryInterface {
    @Override
    public CustomPoint createPoint(int x, int y) {
        return new CustomPoint(x,y);
    }
}
