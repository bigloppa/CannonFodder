import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Level level = new Level();
        ArrayList<Item> itemArrayList = new ArrayList<Item>();
        itemArrayList.add(new Wand("wand2",12,34));
        itemArrayList.add(new Shield("Shield1",12,12));
        itemArrayList.add(new Sword("Sword1",21,23));
        itemArrayList.add(new Wand("wand1",12,34));
        itemArrayList.add(new Shield("Shield2",12,12));
        itemArrayList.add(new Sword("Sword2",21,23));

        level.setAllItems(itemArrayList);



        System.out.println("CANNON FODDER");
        Character fighter = new Fighter(level.getAllItems());
        Character healer = new Healer(level.getAllItems());
        Character tank = new Tank(level.getAllItems());


        level.addCharacter(fighter);
        level.addCharacter(healer);
        level.addCharacter(tank);

        level.groundAdd(new Wand("wand",2,3));

        boolean doesGameContinue = true;


        while (doesGameContinue) {
            boolean doesRoundContinue = true;
            level.generateEnemy();
            level.display();


            while (true) {
                level.checkDeath();
                String[] userInput = scanner.nextLine().split(" ");


                if("NEXT".equals(userInput[0])){
                    boolean doesRoundEnd = true;
                    for (Character character : level.getCharacters()) {
                        if (character instanceof Enemy) {
                            doesRoundEnd = false;

                        }
                    }

                    if (doesRoundEnd){
                        break;
                    }else {
                        System.out.println("There are enemies you can't go to the next level.");
                        continue;

                    }


                }

                try {

                    for (int i = 0; i < 2; i++) {
                        String arrayCheck = userInput[i];
                    }

                } catch (ArrayIndexOutOfBoundsException exception) {
                    System.out.println("Action entered incorrectly.");
                    continue;
                }



                if (userInput[1].equals("attack")){
                    try {


                        Character selectedTarget = level.selectTarget(userInput);
                        Character selectedCharacter = level.selectChar(userInput);
                        selectedCharacter.attack(selectedTarget);
                    }catch (NullPointerException exception){
                        System.out.println("Character cannot be found.");
                        continue;
                    }

                }else if (userInput[1].equals("examine")){
                    try {


                        Character selectedCharacter = level.selectChar(userInput);
                        Item selectedItem = level.selectItem(userInput, selectedCharacter);
                        selectedItem.display();
                    }catch (NullPointerException exception){
                        System.out.println("The Item or the Character cannot be found");
                        continue;
                    }

                }else if (userInput[1].equals("listinventory")){
                    try {

                        Character selectedCharacter = level.selectChar(userInput);
                        selectedCharacter.listInventory();

                    }catch (NullPointerException exception){
                        System.out.println("Character cannot be found");
                        continue;
                    }

                }else if (userInput[1].equals("pick")){
                    try {


                        Character selectedCharacter = level.selectChar(userInput);
                        Item selectedItem = level.selectItem(userInput, selectedCharacter);
                        if (selectedCharacter.pick(selectedItem)) {
                            ArrayList<Item> tempList = level.getAllItems();
                            tempList.remove(selectedItem);
                            level.setAllItems(tempList);
                        }
                    }catch (NullPointerException exception){
                        System.out.println("The Item or the Character cannot be found");
                        continue;
                    }

                }else if (userInput[1].equals("wield")){

                }else if (userInput[1].equals("wear")){
                    Character selectedCharacter = level.selectChar(userInput);
                    Item wornItem = selectedCharacter.wear(level.getGround(), userInput);
                    if (wornItem != null) {
                        level.groundRemove(wornItem);
                    }
                }else {
                    System.out.println("Action entered incorrectly.");
                    continue;
                }

                level.checkDeath();



                doesGameContinue = false;
                for (Character character: level.getCharacters()){
                    if (!(character instanceof Enemy)){
                        doesGameContinue = true;
                    }
                }

                try {
                    level.enemyAttacks();
                }catch (Exception ignored){

                }


                level.setLevelNum(level.getLevelNum()+1);

            }
        }

    }
}
