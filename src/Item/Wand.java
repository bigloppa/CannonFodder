package Item;

import Character.Character;



public class Wand extends Weapon {


    public Wand(String name,int weight,int attackDmg){
        super(name,weight,attackDmg);
    }


    @Override
    public void specialAttack(Character selectedTarget,Character selectedCharacter){
        long finalHealth = selectedTarget.getHp()+(long) selectedCharacter.getIntelligence();
        if (finalHealth>35&& selectedCharacter.getState() == 2) {
            selectedTarget.setHp(35);
        }else if (selectedCharacter.getHp()>=0){
            selectedCharacter.setHp(finalHealth);
        }else{
            System.out.println("A dead character cannot be healed.");
        }

    }




    @Override
    public int calculateDmg(Character character) {
        return getAttackDmg()*character.getIntelligence();
    }



}
