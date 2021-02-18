package by.metelski.quadrangle.observer.impl;

import by.metelski.quadrangle.action.ShapeCalculator;
import by.metelski.quadrangle.action.impl.QuadrangleCalculator;
import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.entity.ShapeParametersStorage;
import by.metelski.quadrangle.observer.Observer;
import by.metelski.quadrangle.observer.QuadrangleEvent;
import by.metelski.quadrangle.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleObserver implements Observer {
    private Warehouse warehouse= Warehouse.getInstance();;
    private ShapeCalculator calculator=new QuadrangleCalculator();;
    private ShapeParametersStorage shapeParametersStorage;
    private Quadrangle quadrangle;
    public static final Logger logger = LogManager.getLogger();

    @Override
    public void parameterChanged(QuadrangleEvent event) {
        double perimeter;
        double area;
        quadrangle= event.getSource();
        logger.log(Level.INFO,"parameters changed; shape: " + quadrangle);
        perimeter=calculator.findPerimeter(quadrangle);
        area=calculator.findArea(quadrangle);
            shapeParametersStorage =warehouse.getShapeParameters(quadrangle.getId());
        if(shapeParametersStorage!=null){
            shapeParametersStorage.setArea(area);
            shapeParametersStorage.setPerimeter(perimeter);
        }else {
            shapeParametersStorage= new ShapeParametersStorage(area,perimeter);
        }
        warehouse.putShapeParameters(quadrangle.getId(),shapeParametersStorage);
    }
}
