package by.metelski.quadrangle.warehouse;

import by.metelski.quadrangle.entity.ShapeParametersStorage;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private final static Warehouse instance = new Warehouse();
    private Map<Long, ShapeParametersStorage> shapeParametersMap = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public void putShapeParameters(long id, ShapeParametersStorage shapeParametersStorage) {
        shapeParametersMap.put(id, shapeParametersStorage);
    }

    public ShapeParametersStorage getShapeParameters(long id) {
        return shapeParametersMap.get(id);
    }

    public boolean removeShapeParameters(long id, ShapeParametersStorage shapeParametersStorage) {
        return shapeParametersMap.remove(id, shapeParametersStorage);
    }
}
