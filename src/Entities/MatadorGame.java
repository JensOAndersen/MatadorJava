package Entities;

import java.util.ArrayList;
import java.util.Scanner;

public class MatadorGame {
    ArrayList<BaseField> gameBoard = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    int currentPlayer = 0;

    private Dice dice = new Dice();

    public MatadorGame(){
        //setting up scanner for use in the constructor
        Scanner s = new Scanner(System.in);
        int amountOfPlayers = 0; //amount of players, to be set in a while-true/try-catch

        System.out.println("Welcome to Matador, please write how many players you want to add");

        while(true){ //while-true/try-catch block to keep asking the player how many players they want, breaks on completion
            try {
                amountOfPlayers = Integer.parseInt(s.nextLine());
                break;
            } catch(Exception ex){
                System.out.println("you didnt write a recognizeable number, please try again");
                System.out.println(ex.getMessage());
            }
        }

        if (amountOfPlayers > 1){ //if-else as you cant play matador alone or with zero players
            for (int i = 0; i <amountOfPlayers; i++){
                System.out.println("Please write the name for player " + (i+1));
                String name = s.nextLine();
                players.add(new Player(name));
            }
        } else {
            System.out.println("You cant play Matador alone, or with no players, exiting setup of the current game");
        }
    }

    private void addPlayer(Player p){
        players.add(p);
    }

    private void takeTurn(){
        Player p = players.get(currentPlayer);
        System.out.println("It is " + p.GetName()+"'s turn!");
        p.Message("Rolls the dice, he hits a " + dice.RollDie());

//        for (int i = 0; i <= dice.getValue();
//             i++) {
//            p.Position(1);
//        }
    }
}
