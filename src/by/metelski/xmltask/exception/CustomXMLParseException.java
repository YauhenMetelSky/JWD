package by.metelski.xmltask.exception;

public class CustomXMLParseException extends Exception{
    public CustomXMLParseException() {
        super();
    }
    public CustomXMLParseException(String message) {
        super(message);
    }
    public CustomXMLParseException(Throwable cause) {
        super(cause);
    }
    public CustomXMLParseException(String message, Throwable cause) {
        super(message, cause);
    }


}
