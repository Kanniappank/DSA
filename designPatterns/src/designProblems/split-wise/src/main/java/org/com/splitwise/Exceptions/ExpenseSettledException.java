package org.com.splitwise.Exceptions;

public class ExpenseSettledException extends Exception{
    public ExpenseSettledException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
