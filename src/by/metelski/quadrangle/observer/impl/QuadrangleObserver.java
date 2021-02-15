package by.metelski.quadrangle.observer.impl;

import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.observer.Observer;
import by.metelski.quadrangle.observer.QuadrangleEvent;

public class QuadrangleObserver implements Observer {
    @Override
    public void parameterChanged(QuadrangleEvent event) {
        Quadrangle quadrangle= event.getSource();
//realisation
        //get param
        //calculate
        //get instance warehouse
        //put data by id
    }
}
