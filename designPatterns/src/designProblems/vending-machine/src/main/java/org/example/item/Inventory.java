package org.example.item;

public class Inventory {
    ItemShelf[] inventory = null;

    public Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initializeEmptyInventory();
    }

    public void initializeEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < inventory.length; i++) {
            ItemShelf space = new ItemShelf(startCode);
            inventory[i] = space;
            startCode++;
        }
    }

    public boolean hasItems() {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.checkIsSold()) {
                return false;
            }
        }
        return true;
    }

    public void addItem(Item item, int code) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == code) {
                itemShelf.addItem(item);
                return;
            }
        }
        throw new Exception("Invalid code");
    }

    public Item getItem(int itemCode) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == itemCode) {
                if (itemShelf.isSoldOut()) {
                    throw new Exception("Item already sold out");
                } else {
                    return itemShelf.getItems().getFirst();
                }
            }
        }
        throw new Exception("Invalid item code");
    }

    public void updateSoldOutItem(int itemCode) {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == itemCode) {
                if (itemShelf.getItems().isEmpty()) {
                    itemShelf.setSoldOut(true);
                }
            }
        }
    }

    public void removeItem(int itemCode) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == itemCode) {
                itemShelf.removeItem(itemShelf.getItems().getFirst());
                return;
            }
        }
        throw new Exception("Invalid Item code");
    }
}