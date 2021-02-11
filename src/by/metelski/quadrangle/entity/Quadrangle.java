package by.metelski.quadrangle.entity;

import by.metelski.quadrangle.exception.QuadrangleException;
import by.metelski.quadrangle.generator.IdGenerator;

public class Quadrangle {
    private CustomPoint[] points;
    private long id;
    private String name;

    public Quadrangle(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC,String name){
        points=new CustomPoint[4];
        points[0] = pointA;
        points[1]=pointB;
        points[2]=pointC;
        points[3]=new CustomPoint();
        this.name = name;
        id = IdGenerator.getId();
    }
     public Quadrangle(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC, CustomPoint pointD,String name){
        points=new CustomPoint[4];
        points[0] = pointA;
        points[1]=pointB;
        points[2]=pointC;
        points[3]=pointD;
        this.name=name;
        id = IdGenerator.getId();
    }

    public CustomPoint[] getPoints() {
        return points.clone();
    }

    public void setPoints(CustomPoint[] points) {
        this.points = points;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomPoint getPoint(int index) throws QuadrangleException {
        if(index<points.length) {
            return points[index];
        } else {
            throw new QuadrangleException("Illegal point index : " + index);
        }
    }
}
