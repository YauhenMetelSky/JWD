package by.metelski.quadrangle.entity;

import by.metelski.quadrangle.generator.IdGenerator;

public class CustomPoint {
    private final long pointId;
    private String name;
    private final int xCoordinate;
    private final int yCoordinate;

    public CustomPoint() {
        xCoordinate=0;
        yCoordinate=0;
        pointId=IdGenerator.getId();
        name="name";
    }

    public CustomPoint(int xCoordinate, int yCoordinate,String name) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.name = name;
        this.pointId = IdGenerator.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }
}
