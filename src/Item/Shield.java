package Item;

import Character.Character;


public class Shield extends Weapon implements WeaponOperations {

     private int leftChancesToStun;



    public Shield(String name, int weight, int attackDmg) {
        super(name, weight, attackDmg);

    }

    @Override
    public int calculateDmg(Character character) {
        return getAttackDmg()*character.getVitality();
    }




    @Override
    public void specialAttack(Character selectedTarget, Character selectedCharacter) {
        if (leftChancesToStun>0){
            selectedTarget.setState(1);
        }else {
            System.out.println("This character cannot stun anymore.");
        }
        leftChancesToStun--;
    }


}
