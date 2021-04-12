package by.bakhar.task3.exception;

public class ConeException extends Exception {
    public ConeException() {
    }

    public ConeException(String message) {
        super(message);
    }

    public ConeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConeException(Throwable cause) {
        super(cause);
    }
}
