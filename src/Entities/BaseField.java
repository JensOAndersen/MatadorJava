package Entities;

abstract class BaseField {
    String name = "";

    public BaseField(String name){
        this.name = name;
    }

    public void passed(Player p){
        p.message("Just passed: " + name);
    }

    public void landed(Player p){
        p.message("Just Landed on: " + name);
    }

}
