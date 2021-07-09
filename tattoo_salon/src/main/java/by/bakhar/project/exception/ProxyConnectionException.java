package by.bakhar.project.exception;

public class ProxyConnectionException extends Exception{
    public ProxyConnectionException() {
    }

    public ProxyConnectionException(String message) {
        super(message);
    }

    public ProxyConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProxyConnectionException(Throwable cause) {
        super(cause);
    }
}
