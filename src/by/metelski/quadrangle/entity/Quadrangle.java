package by.metelski.quadrangle.entity;

import by.metelski.quadrangle.exception.QuadrangleException;
import by.metelski.quadrangle.observer.Observable;
import by.metelski.quadrangle.observer.Observer;
import by.metelski.quadrangle.observer.QuadrangleEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quadrangle extends AbstractShape implements Observable {
    private CustomPoint[] points;
    public static final Logger logger = LogManager.getLogger();
    private List<Observer>observers = new ArrayList<>();

     public Quadrangle(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC, CustomPoint pointD){
        points=new CustomPoint[4];
        points[0] = pointA;
        points[1]=pointB;
        points[2]=pointC;
        points[3]=pointD;
        logger.log(Level.INFO,"created Quadrangle, id: " + getId());
    }
    public Quadrangle(CustomPoint[] points){
        this.points=points;
        logger.log(Level.INFO,"created Quadrangle, id: " + getId());
    }

    public CustomPoint[] getPoints() {
        return points.clone();
    }

    public void setPoints(CustomPoint[] points) {
        this.points = points;
        notifyObservers();
    }
    public void setPoint(CustomPoint point,int index) throws QuadrangleException {
         if(index>=0&&index<points.length) {
             points[index] = point;
             notifyObservers();
         }else {
             throw new QuadrangleException("illegal argument index="+index+", less than 0 or greater than "+points.length);
         }
    }

    public CustomPoint getPoint(int index) throws QuadrangleException {
        if(index<points.length) {
            return points[index];
        } else {
            throw new QuadrangleException("Illegal point index : " + index);
        }
    }

    @Override
    public void attach(Observer observer) {
        if(observer!=null){
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
         observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        QuadrangleEvent event = new QuadrangleEvent(this);
        for (Observer observer:observers) {
            observer.parameterChanged(event);
        }
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Arrays.hashCode(points);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Quadrangle other = (Quadrangle) obj;
        if (!Arrays.equals(points, other.points))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Quadrangle{");
        sb.append(super.toString());
        sb.append("\npoints=").append(Arrays.toString(points));
        sb.append('}');
        return sb.toString();
    }
}
