package Entities;

public class Safe extends BaseField {
    protected double reward;

    public Safe(Double reward, String name){
        super(name);
        this.reward = reward;
    }

    //override super landed, to message as well as deposit money into the players account
    @Override
    public void landed(Player p) {
        super.landed(p);
        p.depositToAccount(reward);
        p.message(p.getName()+" received " + reward + " as reward.");
    }

}
