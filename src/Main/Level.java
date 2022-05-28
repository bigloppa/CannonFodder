package Main;

import Item.*;
import Character.*;
import  Character.Character;
import Item.Item;


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {
    private ArrayList<Item> ground;
    private static int levelNum;
    private static int enemyNum;
    private static ArrayList<Item> allItems;
    private ArrayList<Character> characters;
    private ArrayList<Enemy> enemies;

    public static int getLevelNum() {
        return levelNum;
    }

    public static void setLevelNum(int levelNum) {
        Level.levelNum = levelNum;
    }

    public static int getEnemyNum() {
        return enemyNum;
    }

    public static void setEnemyNum(int enemyNum) {
        Level.enemyNum = enemyNum;
    }

    public ArrayList<Item> getGround() {
        return ground;
    }

    public void setGround(ArrayList<Item> ground) {
        this.ground = ground;
    }


    public ArrayList<Item> getGeneralInv() {
        return allItems;
    }

    public void setGeneralInv(ArrayList<Item> allItem) {
        allItems = allItem;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("CANNON FODDER");
        Fighter fighter = new Fighter(allItems);
        Healer healer = new Healer(allItems);
        Tank tank = new Tank(allItems);

        Level level = new Level();



        ArrayList<Character> characters = new ArrayList<Character>();
        characters.add(fighter);
        characters.add(healer);
        characters.add(tank);

        ArrayList<Enemy> enemies = new ArrayList<>();
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
            Character selectedTarget = level.selectTarget(userInput, enemies);
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
                        allItems.remove(selectedItem);
                    }
                    break;

                case "wield":

                    Item wieldedItem = selectedCharacter.wield(level.ground, userInput);
                    if (wieldedItem != null) {
                        allItems.remove(wieldedItem);
                    }
                    break;

                case "special":


                case "NEXT":
                    flag = false;


            }
        }




    }

    public Character selectChar(String[] userInput,ArrayList<Character>characters){
        for(Character character: characters){
            if (character.getName().equals(userInput[0])){
                return character;
            }
        }

        return null;

    }

    public Enemy selectTarget(String[] userInput,ArrayList<Enemy> enemies){
        for (Enemy enemy: enemies){
            if (enemy.getName().equals(userInput[2])){
                return enemy;
            }
        }

        return null;

    }

    public Item selectItem(String[] userInput,Character selectedCharacter){
        ArrayList<Item> tempList = new ArrayList<Item>();
        tempList.addAll(ground);
        tempList.addAll(selectedCharacter.getInventory());
        tempList.add(selectedCharacter.getWeapon());
        tempList.add(selectedCharacter.getClothing());
        for (Item item: tempList){
            if (item.getName().equals(userInput[2])){
                return item;
            }

        }

        return null;
    }


    public Item selectRandomItem() {
        SecureRandom secureRandom = new SecureRandom();

        int randomNum = secureRandom.nextInt(allItems.size());
        for (Item item : allItems) {
            if(randomNum == allItems.indexOf(item)&& item instanceof Sword){
                return item;
            }

        }
        return null;



    }







}
