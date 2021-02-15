package by.metelski.quadrangle.factory.impl;

import by.metelski.quadrangle.entity.CustomPoint;
import by.metelski.quadrangle.entity.CustomShape;
import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.factory.FactoryInterface;
import by.metelski.quadrangle.validate.IsDiagonal;

public class ShapeFactory implements FactoryInterface {
    @Override
    public CustomShape createShape(String name,int[] pointsCoordinates) {
        CustomPoint[] points = createPoints(pointsCoordinates);
        sortPoints(points);
        Quadrangle quadrangle = new Quadrangle(points,"name");
        return quadrangle;
    }

private CustomPoint[] createPoints(int[] pointsCoordinates){
    CustomPoint[] points = new CustomPoint[4];
    for (int i = 0; i <pointsCoordinates.length/2 ; i++) {
        int tmpIndex =i*2;
        points[i] = new CustomPoint(pointsCoordinates[tmpIndex],pointsCoordinates[tmpIndex+1]);
    }
    if(pointsCoordinates.length==6){
        points[3] = new CustomPoint(0,0);
    }
    return points;
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
