package by.metelski.quadrangle.observer.impl;

import by.metelski.quadrangle.action.ShapeCalculator;
import by.metelski.quadrangle.action.impl.QuadrangleCalculator;
import by.metelski.quadrangle.entity.Quadrangle;
import by.metelski.quadrangle.entity.ShapeParametersStorage;
import by.metelski.quadrangle.observer.Observer;
import by.metelski.quadrangle.observer.QuadrangleEvent;
import by.metelski.quadrangle.warehouse.Warehouse;

public class QuadrangleObserver implements Observer {
    private Warehouse warehouse= Warehouse.getInstance();;
    private ShapeCalculator calculator=new QuadrangleCalculator();;
    private ShapeParametersStorage shapeParametersStorage;
    private Quadrangle quadrangle;

    @Override
    public void parameterChanged(QuadrangleEvent event) {
        double perimeter;
        double area;
        quadrangle= event.getSource();
        perimeter=calculator.findPerimeter(quadrangle);
        area=calculator.findArea(quadrangle);
            shapeParametersStorage =warehouse.getShapeParameters(quadrangle.getId());
        if(shapeParametersStorage!=null){
            shapeParametersStorage.setArea(area);
            shapeParametersStorage.setName(quadrangle.getName());
            shapeParametersStorage.setPerimeter(perimeter);
        }else {
            shapeParametersStorage= new ShapeParametersStorage(quadrangle.getName(),area,perimeter);
        }
        warehouse.putShapeParameters(quadrangle.getId(),shapeParametersStorage);
    }
}
