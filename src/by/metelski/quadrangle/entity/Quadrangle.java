package by.metelski.quadrangle.entity;

import by.metelski.quadrangle.exception.QuadrangleException;
import by.metelski.quadrangle.observer.Observable;
import by.metelski.quadrangle.observer.Observer;
import by.metelski.quadrangle.observer.QuadrangleEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Quadrangle extends CustomShape implements Observable {
    private CustomPoint[] points;
    public static final Logger logger = LogManager.getLogger();
    private List<Observer>observers = new ArrayList<>();

//    public Quadrangle(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC,String name){
//        points=new CustomPoint[4];
//        points[0] = pointA;
//        points[1]=pointB;
//        points[2]=pointC;
//        points[3]=new CustomPoint();
//        setName(name);
//        logger.log(Level.INFO,"created Quadrangle name: \"" + name+"\", shape id: " + getId());
//    }
     public Quadrangle(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC, CustomPoint pointD,String name){
        points=new CustomPoint[4];
        points[0] = pointA;
        points[1]=pointB;
        points[2]=pointC;
        points[3]=pointD;
       setName(name);
         logger.log(Level.INFO,"created Quadrangle name: \"" + name+"\", shape id: " + getId());
    }
    public Quadrangle(CustomPoint[] points,String name){
        this.points=points;
        setName(name);
        logger.log(Level.INFO,"created Quadrangle name: \"" + name+"\", shape id: " + getId());
    }

    public CustomPoint[] getPoints() {
        return points.clone();
    }

    public void setPoints(CustomPoint[] points) {
        this.points = points;
        notifyObservers();
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
}
