package org.example.states;

public class DispenseState implements VendingMachineState{

    public DispenseState(){
        System.out.println("Vending machine enters Dispense state");
    }
    @Override
    public String getStateName() {
        return "DispenseState";
    }

    @Override
    public VendingMachineState next(VendingMachineContext context) {
       return new IdleState();
    }
}
