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

        System.out.println("CANNON FODDER");
        Fighter fighter = new Fighter(level.getAllItems());
        Healer healer = new Healer(level.getAllItems());
        Tank tank = new Tank(level.getAllItems());





        ArrayList<Character> characters = new ArrayList<Character>();
        characters.add(fighter);
        characters.add(healer);
        characters.add(tank);


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

                    Item wieldedItem = selectedCharacter.wield(level.getGround(), userInput);
                    if (wieldedItem != null) {
                        ArrayList<Item> tempList = level.getAllItems();
                        tempList.remove(wieldedItem);
                        level.setAllItems(tempList);
                    }
                    break;

                case "special":
                case "wear":



                case "NEXT":
                    flag = false;


            }
        }

    }
}
