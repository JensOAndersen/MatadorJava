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
    public void Landed(Player p) {
        super.Landed(p);
        if (owner  == null){ //if the field doesnt have an owner, ask the player if he wants to buy it
            System.out.println(name + " currently has no owner.");
            if (p.AskQuestion("Do you want to buy it for kr:"+price+"?")){

                //if the player doesnt have enough money he'll be told so
                if (p.getBalance() >= price){
                    p.WithdrawFromAccount(price);
                    owner = p;
                } else {
                    p.message("Currently doesn't have another money to buy " + name);
                }
            }
        } else { //if the field already has an owner
            p.message("paid " + getRent() + " as rent to " + owner.getName() +" for landing on " + name+"!");
            owner.DepositToAccount(p.WithdrawFromAccount(getRent()));
        }
    }

    protected void AccessSuperLanded(Player p){ //figure out something else for this crap
        super.Landed(p);
    }
}
