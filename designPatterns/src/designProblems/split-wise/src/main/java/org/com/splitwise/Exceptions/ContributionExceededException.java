package org.com.splitwise.Exceptions;

public class ContributionExceededException extends Exception {
    public ContributionExceededException(String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
