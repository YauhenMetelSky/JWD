package by.metelski.quadrangle.warehouse;

import by.metelski.quadrangle.entity.ShapeParametersStorage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private final static Warehouse instance = new Warehouse();
    private Map<Long, ShapeParametersStorage> shapeParametersMap = new HashMap<>();
    public static final Logger logger = LogManager.getLogger();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public void putShapeParameters(long id, ShapeParametersStorage shapeParametersStorage) {
        shapeParametersMap.put(id, shapeParametersStorage);
        logger.log(Level.INFO, "putted new data in warehouse id=" + id + "storage: " + shapeParametersStorage);
    }

    public ShapeParametersStorage getShapeParameters(long id) {
        return shapeParametersMap.get(id);
    }

    public boolean removeShapeParameters(long id, ShapeParametersStorage shapeParametersStorage) {
        logger.log(Level.INFO, "removed data from warehouse id=" + id + "storage: " + shapeParametersStorage);
        return shapeParametersMap.remove(id, shapeParametersStorage);
    }
}
