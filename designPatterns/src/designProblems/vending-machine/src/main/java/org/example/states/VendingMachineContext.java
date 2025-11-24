package org.example.states;

import lombok.Data;
import org.example.Coin;
import org.example.item.Inventory;
import org.example.item.Item;

import java.util.ArrayList;
import java.util.List;

@Data
public class VendingMachineContext {

    private VendingMachineState currentState;
    private Inventory inventory;
    private List<Coin> coinList;

    private int selectedItemCode;

    public VendingMachineContext() {
        inventory = new Inventory(10);
        coinList = new ArrayList<>();
        currentState = new IdleState();
        System.out.println("Initialized with " + currentState);
    }

    public void advanceState() {
        currentState = currentState.next(this);
        System.out.println("Current state is " + currentState.getStateName());
    }

    public void clickOnInsertCoinButton(Coin coin) {
        if (currentState instanceof IdleState || currentState instanceof HasMoneyState) {
            System.out.println("Inserted " + coin.name() + " of value " + coin.value);
            coinList.add(coin);
            advanceState();
        } else {
            System.out.println("Cannot insert Coin in " + currentState.getStateName());
        }
    }

    public void clickOnStartProductSelectionButton(int itemCode) {
        if (currentState instanceof HasMoneyState) {
            advanceState();
            selectProduct(itemCode);
        } else {
            System.out.println("product selection button can only be selected in HasMoney State");
        }
    }

    public int getBalance() {
        int balance = 0;
        for (Coin coin : coinList) {
            balance += coin.value;
        }
        return balance;
    }

    public void resetBalance() {
        coinList.clear();
    }

    public void resetSelection() {
        selectedItemCode = 0;
    }

    public void dispenseItem(int itemCode) {
        if (currentState instanceof DispenseState) {
            try {
                Item item = inventory.getItem(itemCode);
                System.out.println("Dispensing " + item.getItemType());
                inventory.removeItem(itemCode);
                inventory.updateSoldOutItem(itemCode);
                resetBalance();
                resetSelection();
                advanceState();
            } catch (Exception e) {
                System.out.println("failed to dispense the product with the code " + currentState);
            }
        } else {
            System.out.println("System cannot dispense in " + currentState);
        }
    }

    public void selectProduct(int itemCode) {
        if (currentState instanceof SelectionState) {
            try {
                Item item = inventory.getItem(itemCode);
                int balance = getBalance();
                if (item.getPrice() > balance) {
                    System.out.println("Insufficient amount Product price is " + item.getPrice() + ", paid price is " + balance);
                    return;
                }
                setSelectedItemCode(itemCode);
                advanceState();
                dispenseItem(itemCode);
                if (balance > item.getPrice()) {
                    int change = balance - item.getPrice();
                    System.out.println("returning change " + change);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Products can only be selected in selection state");
        }
    }

    public void updateInventory(Item item, int itemCode) {
        if (currentState instanceof IdleState) {
            try {
                inventory.addItem(item, itemCode);
                System.out.println("added " + item.getItemType() + " to slot " + itemCode);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else {
            System.out.println("Items can only be updated in the IdelState");
        }
    }
}
