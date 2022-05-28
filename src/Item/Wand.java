package Item;

import Character.Character;



public class Wand extends Weapon {
    public Wand(){

    }

    public Wand(String name,int weight,int attackDmg){
        super(name,weight,attackDmg);
    }




    @Override
    public int calculateDmg(Character character) {
        return getAttackDmg()*character.getIntelligence();
    }



}
