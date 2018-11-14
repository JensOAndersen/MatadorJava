package Entities;

public class Lot extends BaseField {
    protected double rent;

    private double price;
    private Player owner;

    public Lot(String name, Double price, Double rent){
        super(name);
        this.price = price;
        this.rent = rent;
    }

    //get-set
    public void setOwner(Player p){
        owner = p;
    }

    public Player getOwner() {
        return owner;
    }

    public double getRent() {
        return rent;
    }
    //methods

    //TODO: move transaction code into another method, so its easier when transferring lots between players
    @Override
    public void landed(Player p) {
        super.landed(p);
        if (owner == null){ //if the field doesnt have an owner, ask the player if he wants to buy it
            System.out.println(name + " currently has no owner.");
            if (p.askQuestion("Do you want to buy "+name+" for kr:"+price+"?, your current balance is: " + p.getBalance())){

                //if the player doesnt have enough money he'll be told so
                if (p.getBalance() >= price){
                    p.withdrawFromAccount(price);
                    owner = p;
                } else {
                    p.message("Currently doesn't have another money to buy " + name);
                }
            }
        } else if(p != owner) { //if the field already has an owner
            p.message("paid " + getRent() + " as rent to " + owner.getName() +" for landing on " + name+"!");
            owner.depositToAccount(p.withdrawFromAccount(getRent()));
        } else {
            p.message("Owns " + name + " take a rest and enjoy a cup of coffee");
        }
    }

//    protected void AccessSuperLanded(Player p){ //figure out something else for this crap
//        super.landed(p);
//    }
}
