package Entities;

import java.util.ArrayList;

public class MatadorGame {
    ArrayList<BaseField> gameBoard = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    int currentPlayer = 0;

    private Dice dice = new Dice();


    public void AddPlayer(Player p){
        players.add(p);
    }

    public void TakeTurn(){
        Player p = players.get(currentPlayer);
        System.out.println("It is " + p.GetName()+"'s turn!");
        p.Message("Rolls the dice, he hits a " + dice.RollDie());

        for (int i = 0; i <= dice.getValue();
             i++) {
            p.Position(1);
        }
    }
}
