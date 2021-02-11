package by.metelski.quadrangle.exception;

public class QuadrangleException extends Exception {
    public QuadrangleException() {
        super();
    }

    public QuadrangleException(String message) {
        super(message);
    }

    public QuadrangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuadrangleException(Throwable cause) {
        super(cause);
    }
}
