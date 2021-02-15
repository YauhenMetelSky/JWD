package by.metelski.quadrangle.factory.impl;

import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.CustomShape;
import by.metelski.quadrangle.factory.FactoryInterface;

public class ShapeFactory implements FactoryInterface {
    @Override
    public CustomShape createShape(String name,CustomPoint... point) {
        CustomPoint[] points = new CustomPoint[4];
        if(point.length==3){
            points[3] = new CustomPoint(0,0);
        } else{

        }
        return null;
    }


    private CustomPoint[] sortPoints(CustomPoint[] points){

        return null;
    }

}
