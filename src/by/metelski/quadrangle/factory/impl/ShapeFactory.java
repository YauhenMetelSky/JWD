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
        if(points.length==3){
            CustomPoint[] tmpPoints=new CustomPoint[4];
            for (int i = 0; i < 3; i++) {
                tmpPoints[i] = points[i];
            }
            tmpPoints[3] = pointFactory.createPoint(DEFAULT_X,DEFAULT_Y);
        }
        sortPoints(points);
        Quadrangle quadrangle = new Quadrangle(points,"name");
        return quadrangle;
    }

//private CustomPoint[] createPoints(int[] pointsCoordinates){
//    CustomPoint[] points = new CustomPoint[4];
//    for (int i = 0; i <pointsCoordinates.length/2 ; i++) {
//        int tmpIndex =i*2;
//        points[i] = new CustomPoint(pointsCoordinates[tmpIndex],pointsCoordinates[tmpIndex+1]);
//    }
//    if(pointsCoordinates.length==6){
//        points[3] = new CustomPoint(0,0);
//    }
//    return points;
//}
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
