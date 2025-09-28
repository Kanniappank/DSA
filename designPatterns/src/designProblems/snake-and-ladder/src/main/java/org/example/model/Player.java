package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    private final String name;
    @Setter
    private int position;
    @Setter
    private boolean hasWon;

    public Player(String name) {
        this.name = name;
        this.position = 0;
        this.hasWon = false;
    }
}
