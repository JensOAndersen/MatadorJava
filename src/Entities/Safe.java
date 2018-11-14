package Entities;

public class Safe extends BaseField {
    protected double reward;

    public Safe(Double reward, String name){
        super(name);
        this.reward = reward;
    }

    //override super landed, to message as well as deposit money into the players account
    @Override
    public void Landed(Player p) {
        super.Landed(p);
        p.DepositToAccount(reward);
        p.message(p.getName()+" received " + reward + " as reward.");
    }

}
