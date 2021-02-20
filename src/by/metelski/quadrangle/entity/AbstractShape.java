package by.metelski.quadrangle.entity;

import by.metelski.quadrangle.generator.IdGenerator;

public abstract class AbstractShape {
    private long id;

    public AbstractShape() {
        this.id = IdGenerator.getId();
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        AbstractShape other = (AbstractShape) obj;
        if (id != other.id)
            return false;
        return true;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("\nid=").append(id);
        return sb.toString();
    }
}
