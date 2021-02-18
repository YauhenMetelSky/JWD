package by.metelski.quadrangle.factory.impl;

import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.AbstractShape;
import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.factory.ShapeFactoryInterface;
import by.metelski.quadrangle.validate.IsDiagonal;

public class ShapeFactory implements ShapeFactoryInterface {
    PointFactory pointFactory = new PointFactory();
    private final static int DEFAULT_X = 0;
    private final static int DEFAULT_Y =0;
    @Override
    public AbstractShape createShape(String name, CustomPoint[] points) {
        CustomPoint[] tmpPoints=new CustomPoint[4];
        if(points.length==3){
            for (int i = 0; i < 3; i++) {
                tmpPoints[i] = points[i];
            }
            tmpPoints[3] = pointFactory.createPoint(DEFAULT_X,DEFAULT_Y);
        } else {
            tmpPoints = points;
        }
        sortPoints(tmpPoints);
        Quadrangle quadrangle = new Quadrangle(tmpPoints);
        return quadrangle;
    }

    private void sortPoints(CustomPoint[] points){
        for (int i = 1; i <4 ; i++) {
            if(IsDiagonal.isPointOneThreeDiagonal(points)){
             break;
            } else {
                swap(points,i,i+1);
            }
        }
    }
    private void swap(CustomPoint[] points,int index1,int index2){
        CustomPoint tmp = points[index1];
        points[index1]=points[index2];
        points[index2]=tmp;
    }
}
