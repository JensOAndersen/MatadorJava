package Entities;

public class Street extends Lot {
    public static double housePrice = 500;
    private static double housesRentMulti = 0.1;
    private int numberOfHouses = 0;

    public Street(String name, double price, double rent){
        super(name,price,rent);
    }

    @Override
    public void Landed(Player p) {
        //check if owner is p
        if(getOwner() == p){
            p.Message("Just landed on: " + name); // somehow i want to make some logic that removes this line, as its identical to the line in BaseField.java
            p.Message("Owns " + name);
            if (p.AskQuestion("Do you want to buy a house on " + name + "?")){ //ask if the player wants to buy the house
                if(p.GetBalance() >= housePrice){ //make sure we've got enough money to buy the house
                    p.WithdrawFromAccount(housePrice);
                    numberOfHouses++;
                } else {
                    p.Message("Doesn't have enough money to buy " + name);
                }
            }
        } else {
            super.Landed(p);
        }
    }

    //override the base getRent, as rent depends on factors in this downclass
    @Override
    public double getRent(){
        return super.getRent() * (1+housesRentMulti*numberOfHouses);
    }
}
