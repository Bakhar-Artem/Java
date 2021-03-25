package com.bakhar.entity.exception;

public class DynArrayException extends Exception{
    public DynArrayException() {
    }

    public DynArrayException(String message) {
        super(message);
    }

    public DynArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public DynArrayException(Throwable cause) {
        super(cause);
    }

}
