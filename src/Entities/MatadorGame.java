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
                addPlayer(new Player(name));
            }

            setupFields();

            //start the game!
            start();
        } else {
            System.out.println("You cant play Matador alone, or with no players, exiting setup of the current game");
        }
    }

    //main game loop is running in this method;
    public void start(){
        int nOfPlayers = players.size();
        ArrayList<Player> currentPlayers = new ArrayList<>(players);
        Player winningPlayer;

        while(nOfPlayers > 1){

        }
        winningPlayer = currentPlayers.get(0);

        winningPlayer.message("Congratulations, you won the game with account balance: " + winningPlayer.getBalance());
    }

    private void addPlayer(Player p){
        players.add(p);
    }

    private void takeTurn(){
        Player p = players.get(currentPlayer);
        System.out.println("It is " + p.getName()+"'s turn!");
        p.message("Rolls the dice, he hits a " + dice.rollDie());

//        for (int i = 0; i <= dice.getValue();
//             i++) {
//            p.Position(1);
//        }
    }

    //would be pretty nice to be able to read this from a config file or something
    private void setupFields(){
        gameBoard.add(new Start("start",4000));
        gameBoard.add(new Street("Rødovrevej",1200, 120));
        gameBoard.add(new Street("Hvidovrevej",1200,120));
        gameBoard.add(new ShipLine("Øresund A/S",4000,400));
        gameBoard.add(new Street("Roskildevej",2000,200));
        gameBoard.add(new Street("Valby Langgade",2000,200));
        gameBoard.add(new Street("Allégade",2400,240));
        gameBoard.add(new Safe(2000.0,"Besøg i Fængsel"));
        gameBoard.add(new Street("Frederiksberg Alle",2800,280));
        gameBoard.add(new Street("Bülowsvej",2800,280));
        gameBoard.add(new ShipLine("A/S Grenaa Hundested færgefart",4000,400));
        gameBoard.add(new Street("Bernstorffsvej",3600,360));
        gameBoard.add(new Street("Hellerupvej",3600,360));
        gameBoard.add(new Street("Strandvej",4000,400));
        gameBoard.add(new Safe(2000.0,"Parkering"));
        gameBoard.add(new Street("Trianglen",4400,400));
        gameBoard.add(new Street("Østerbrogade",4400,440));
        gameBoard.add(new Street("Grønningen",4800,480));
        gameBoard.add(new ShipLine("Mols Linien A/S",4000,400));
        gameBoard.add(new Street("Bredgade",5200,520));
        gameBoard.add(new Street("Kgs. Nytorv",5200,520));
        gameBoard.add(new Street("Østergade",5600,560));
        gameBoard.add(new Street("Amagertorv",6000,600));
        gameBoard.add(new Street("Vimmelskaftet",6000,600));
        gameBoard.add(new Street("Nygade",6400,640));
        gameBoard.add(new Street("Skandinavisk Linfetrafik A/S",4000,400));
        gameBoard.add(new Street("Frederiksberggade",7000,700));
        gameBoard.add(new Street("Rådhuspladsen",8000,800));

    }
}
