package by.metelski.quadrangle.entity;

public class ShapeParametersStorage {
    private double area;
    private double perimeter;

    public ShapeParametersStorage(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
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
}
