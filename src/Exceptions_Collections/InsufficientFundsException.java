package Exceptions_Collections;

// Custom Checked Exception: Extends 'Exception', forcing callers to handle or declare it
public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        // Passes the custom error message up to the parent Exception class
        super(message);
    }
}