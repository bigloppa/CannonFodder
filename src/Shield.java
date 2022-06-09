import java.security.SecureRandom;
import java.util.ArrayList;

public class Shield extends Weapon{

     private int turnsForStun;
     private ArrayList<Character> stunnedCharacters;

    public Shield(){
        turnsForStun = 4;
        stunnedCharacters = new ArrayList<>();
    }

    public ArrayList<Character> getStunnedCharacters() {
        return stunnedCharacters;
    }

    public void setStunnedCharacters(ArrayList<Character> stunnedCharacters) {
        this.stunnedCharacters = stunnedCharacters;
    }
    public Shield(String name, int weight, int attackDmg) {
        setName(name);
        setWeight(weight);
        setAttackDmg(attackDmg);
        turnsForStun = 4;
        stunnedCharacters = new ArrayList<>();
    }


    @Override
    public int calculateDmg(Character character) {
        return getAttackDmg()*character.getVitality();
    }

    @Override
    public boolean turnPassed() {
        if (turnsForStun<4&&turnsForStun>0){
            turnsForStun--;
            return false;
        }else{
            return true;

        }
    }


    @Override
    public void specialAttack(ArrayList<Character> characters) {
        SecureRandom secureRandom = new SecureRandom();
        ArrayList<Character>enemyList = new ArrayList<>();
        for (Character character:characters){
            if (character instanceof Enemy){
                enemyList.add(character);
            }
        }
        int bound;
        if (enemyList.size()>getAttackDmg()){
            bound = getAttackDmg();
        }else{
            bound = enemyList.size();
        }
        stunnedCharacters = enemyList;

        for (int i = 0; i < bound; i++) {
            int randomNum = secureRandom.nextInt(enemyList.size());

            for (int j = 0; j < enemyList.size(); j++) {

                if (randomNum == j){
                    enemyList.get(j).setState(1);
                    System.out.print(enemyList.get(j).getName()+ " is stunned. ");
                }
            }
            System.out.println();

        }
        turnsForStun--;
    }

    @Override
    public Item generateItem(ArrayList<Item> items) {
        SecureRandom secureRandom = new SecureRandom();
        while (true) {
            int randomNum = secureRandom.nextInt(items.size());
            for (int i = 0; i < items.size(); i++) {
                if (i == randomNum && items.get(i) instanceof Shield) {
                    return items.get(i);
                }
            }
        }
    }



}
