package Entities;

abstract class BaseField {
    String name = "";

    public BaseField(String name){
        this.name = name;
    }

    public void Passed(Player p){
        p.Message("Just passed: " + name);
    }

    public void Landed(Player p){
        p.Message("Just Landed on: " + name);
    }

}
