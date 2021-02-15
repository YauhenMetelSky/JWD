package by.metelski.quadrangle.warehouse;

import by.metelski.quadrangle.entity.ShapeParameters;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private final static Warehouse instance = new Warehouse();
    private Map<Long, ShapeParameters> shapeParametersMap = new HashMap<>();
    private Warehouse(){

    }
    public static Warehouse getInstance(){
        return instance;
    }
    public void addShapeParameters(long id,ShapeParameters shapeParameters){
        shapeParametersMap.put(id,shapeParameters);
    }
    public ShapeParameters getShapeParameters(long id){
        return shapeParametersMap.get(id);
    }
}
