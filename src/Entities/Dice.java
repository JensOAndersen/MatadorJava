package Entities;

import java.util.Random;

public class Dice {
    private static Random rnd = new Random();

    int value = 0;

    public int rollDie(){
        value = rnd.nextInt(6)+1;
        return value;
    }

    public int getValue() {
        return value;
    }
}
