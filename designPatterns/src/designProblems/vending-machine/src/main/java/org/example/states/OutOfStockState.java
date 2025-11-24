package org.example.states;

public class OutOfStockState implements VendingMachineState{

    public OutOfStockState(){
        System.out.println("Vending Machine now enters the Out of Stock state");
    }
    @Override
    public String getStateName() {
        return "OutOfStockState";
    }

    @Override
    public VendingMachineState next(VendingMachineContext context) {
        if(context.getInventory().hasItems()){
            return new IdleState();
        }
        return this;
    }
}
