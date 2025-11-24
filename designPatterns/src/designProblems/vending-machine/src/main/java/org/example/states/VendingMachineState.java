package org.example.states;

public interface VendingMachineState {
    String getStateName();

    VendingMachineState next(VendingMachineContext context);
}
