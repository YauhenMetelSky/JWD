package by.metelski.quadrangle.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomPoint {
    private final int x;
    private final int y;
    public static final Logger logger = LogManager.getLogger();

    public CustomPoint() {
        x =0;
        y =0;
        logger.log(Level.INFO,"created point x="+x+";y="+y);
    }

    public CustomPoint(int x, int y) {
        this.x = x;
        this.y = y;
        logger.log(Level.INFO,"created point x="+x+";y="+y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
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
        CustomPoint other = (CustomPoint) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomPoint{");
        sb.append("\nx=").append(x);
        sb.append(",\ny=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
