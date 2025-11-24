package org.example.states;

public class SelectionState implements VendingMachineState {

    public SelectionState() {
        System.out.println("Vending machine enters Selection State");
    }

    @Override
    public String getStateName() {
        return "Selection State";
    }

    @Override
    public VendingMachineState next(VendingMachineContext context) {

        if(!context.getInventory().hasItems()){
            return new OutOfStockState();
        }
        if(context.getCoinList().isEmpty()){
                return new IdleState();
        }
        if(context.getSelectedItemCode()>0){
            return new
        }
        return this;
    }
}
