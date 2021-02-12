package by.metelski.quadrangle.entity;

import by.metelski.quadrangle.generator.IdGenerator;

public abstract class CustomShape {
    private long id;
    private String name;

    public CustomShape() {
        this.id = IdGenerator.getId();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
