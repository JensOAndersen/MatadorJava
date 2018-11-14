package Entities;

abstract class BaseField {
    String name = "";

    public BaseField(String name){
        this.name = name;
    }

    public void Passed(Player p){
        p.message("Just passed: " + name);
    }

    public void Landed(Player p){
        p.message("Just Landed on: " + name);
    }

}
