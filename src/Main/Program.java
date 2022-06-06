package Main;

import Character.Character;
import Character.*;
import Item.*;

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

        ArrayList<Character> characters = new ArrayList<Character>();
        characters.add(fighter);
        characters.add(healer);
        characters.add(tank);

        level.groundAdd(new Wand("wand",2,3));

        level.display(characters);


        boolean flag =true;

        while (flag) {
            String[] userInput = scanner.nextLine().split(" ");



            try {

                for (int i = 0; i < 2; i++) {
                    String arrayCheck = userInput[i];
                }

            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Action entered incorrectly.");
                continue;
            }


            Character selectedCharacter = level.selectChar(userInput, characters);
            Character selectedTarget = level.selectTarget(userInput, characters);
            Item selectedItem = level.selectItem(userInput, selectedCharacter);




            switch (userInput[1]) {

                case "attack":

                    selectedCharacter.attack(selectedTarget);
                    break;

                case "examine":
                    selectedItem.display();
                    break;

                case "listInventory":

                    selectedCharacter.listInventory();
                    break;

                case "pick":

                    if (selectedCharacter.pick(selectedItem)) {
                       ArrayList<Item> tempList = level.getAllItems();
                       tempList.remove(selectedItem);
                       level.setAllItems(tempList);
                    }
                    break;

                case "wield":


                case "special":
                    selectedCharacter.getWeapon().specialAttack(selectedTarget,selectedCharacter);
                case "wear":
                    Item wornItem = selectedCharacter.wear(level.getGround(),userInput);
                    if (wornItem!= null){
                        level.groundRemove(wornItem);
                    }
                    break;



                case "NEXT":
                    flag = false;
                    break;

            }
        }

    }
}
