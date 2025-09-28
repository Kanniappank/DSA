package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.concurrent.ThreadLocalRandom;
@Getter
@AllArgsConstructor
public class Dice {
    private int minValue;
    private int maxValue;
    private int currentValue;

    public int roll(){
        return ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
    }
}
