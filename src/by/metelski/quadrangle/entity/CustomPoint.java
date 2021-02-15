package by.metelski.quadrangle.entity;

import by.metelski.quadrangle.generator.IdGenerator;

public class CustomPoint {
    private final long pointId;
    private final int x;
    private final int y;

    public CustomPoint() {
        x =0;
        y =0;
        pointId=IdGenerator.getId();
    }

    public CustomPoint(int x, int y) {
        this.x = x;
        this.y = y;
        this.pointId = IdGenerator.getId();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
