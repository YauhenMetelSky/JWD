package by.metelski.quadrangle.entity;

import by.metelski.quadrangle.exception.QuadrangleException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Quadrangle extends CustomShape{
    private CustomPoint[] points;
    public static final Logger logger = LogManager.getLogger();

    public Quadrangle(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC,String name){
        points=new CustomPoint[4];
        points[0] = pointA;
        points[1]=pointB;
        points[2]=pointC;
        points[3]=new CustomPoint();
        setName(name);
        logger.log(Level.INFO,"created Quadrangle name: \"" + name+"\", shape id: " + getId());
    }
     public Quadrangle(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC, CustomPoint pointD,String name){
        points=new CustomPoint[4];
        points[0] = pointA;
        points[1]=pointB;
        points[2]=pointC;
        points[3]=pointD;
       setName(name);
         logger.log(Level.INFO,"created Quadrangle name: \"" + name+"\", shape id: " + getId());
    }

    public CustomPoint[] getPoints() {
        return points.clone();
    }

    public void setPoints(CustomPoint[] points) {
        this.points = points;
    }

    public CustomPoint getPoint(int index) throws QuadrangleException {
        if(index<points.length) {
            return points[index];
        } else {
            throw new QuadrangleException("Illegal point index : " + index);
        }
    }
}
