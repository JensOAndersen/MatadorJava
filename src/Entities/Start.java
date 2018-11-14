package Entities;

public class Start extends Safe {
    public Start(String name, double reward){
        super(reward,name);
    }

    //override passed method, so the player receives a reward when passing
    @Override
    public void passed(Player p) {
        super.passed(p);
        p.depositToAccount(reward);
        p.message("Has received " + reward + " as reward for passing by.");
    }

    @Override
    public void landed(Player p){
        super.landed(p);
        p.message("For landing on " + name + " you receive an additional reward of kr:" + reward/2);
        p.depositToAccount(reward/2);
    }
}
