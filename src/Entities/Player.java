package Entities;

import java.util.Scanner;

public class Player {
    private String name = "";
    private double account = 4000;
    private int fieldPos = 0;

    //constructor
    public Player(String name){
        if(name != "" ){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be whitespace");
        }
    }
    //getters and setters

    public double getBalance(){return account;}
    public String getName(){return name;}

    //overloading the method to make a get-set method, miiight be beautified a bit
    //TODO: beautify this crap
    public int getPosition(){
        return fieldPos;
    }
    public int setPosition(int distance){
        fieldPos += distance;
        return 0;
    }

    //methods

    public void sendMoneyToPlayer(Player p, double amount){
        p.depositToAccount( //withdraws from this player account and deposits to another players account
                this.withdrawFromAccount(amount)
        );
    }

    //TODO: Handle negative balance on the account, take a player from the game and distribute his belongings
    //maybe: sell one of this belongings and deposit the value into the players account and retry selling
    //the easy way would be to sell belongings to the bank, instead of another player
    public double withdrawFromAccount(double amount){
        account -= amount;
        return amount;
    }

    public void depositToAccount(double amount){
        account += amount;
    }

    //prints out a message
    public void message(String msg){
        System.out.println(this.name + ": " + msg);
    }

    //Used to ask the player a question, all calls to this method must end with a questionmark
    public Boolean askQuestion(String msg){
        System.out.println(this.name + ", please answer the question: ");
        System.out.println(msg);

        Scanner s = new Scanner(System.in);

        while(true){
            String answer = s.nextLine();

            switch (answer){
                case "yes":
                    return true;
                case "no":
                    return false;
                default:
                    System.out.println("please only respond with 'yes' or 'no'");
            }
        }
    }
}
