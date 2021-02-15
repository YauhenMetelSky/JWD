package by.metelski.quadrangle.entity;

public class ShapeParameters {
    private String name;
    private double area;
    private double perimeter;

    public ShapeParameters(String name, double area,double perimeter) {
        this.name = name;
        this.area = area;
        this.perimeter = perimeter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
