package by.metelski.quadrangle.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapeParametersStorage {
    private double area;
    private double perimeter;
    public static final Logger logger = LogManager.getLogger();

    public ShapeParametersStorage(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
        logger.log(Level.INFO, "created ShapeParametersStorage; area=" + area + ";perimeter=" + perimeter);
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(area);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(perimeter);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ShapeParametersStorage other = (ShapeParametersStorage) obj;
        if (Double.doubleToLongBits(area) != Double.doubleToLongBits(other.area))
            return false;
        if (Double.doubleToLongBits(perimeter) != Double.doubleToLongBits(other.perimeter))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ShapeParametersStorage{");
        sb.append("area=").append(area);
        sb.append(", perimeter=").append(perimeter);
        sb.append('}');
        return sb.toString();
    }
}
