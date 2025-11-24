package org.example.item;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ItemShelf {
    private int code;
    private List<Item> items;
    private boolean isSoldOut;

    public ItemShelf(int code) {
        this.code = code;
        this.items = new ArrayList<>();
        this.isSoldOut = false;
    }

    public boolean checkIsSold() {
        return this.isSoldOut;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        if (isSoldOut) {
            this.isSoldOut = false;
        }
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

}
