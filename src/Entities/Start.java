package Entities;

public class Start extends Safe {
    public Start(String name, double reward){
        super(reward,name);
    }

    //override passed method, so the player receives a reward when passing
    @Override
    public void Passed(Player p) {
        super.Passed(p);
        p.DepositToAccount(reward);
        p.Message("Has recived " + reward + "as reward for passing by.");
    }
}
