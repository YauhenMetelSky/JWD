package by.metelski.multithreading.exception;

public class FerryException extends Exception{

	public FerryException() {
		super();
	}

	public FerryException(String message, Throwable cause) {
		super(message, cause);
	}

	public FerryException(String message) {
		super(message);
	}

	public FerryException(Throwable cause) {
		super(cause);
	}	
}
