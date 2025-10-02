package org.com.splitwise.Exceptions;

public class ExpenseDoesNotExistException extends Exception {
    public ExpenseDoesNotExistException(String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
