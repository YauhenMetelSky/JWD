package by.metelski.compositechain.exception;

public class CompositeException extends Exception {

	public CompositeException() {
		super();
	}

	public CompositeException(String message, Throwable cause) {
		super(message, cause);
	}

	public CompositeException(String message) {
		super(message);
	}

	public CompositeException(Throwable cause) {
		super(cause);
	}

}
