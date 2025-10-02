package org.com.splitwise.Exceptions;

public class InvalidExpenseState extends Exception{
    public InvalidExpenseState(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
