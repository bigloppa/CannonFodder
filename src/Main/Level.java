package Main;

import Item.*;
import Character.*;
import  Character.Character;


import java.security.SecureRandom;
import java.util.ArrayList;


public class Level implements ILevelManager {
    private ArrayList<IItemManager> ground;
    private int levelNum;
    private int enemyNum;
    private ArrayList<IItemManager> allItems;
    private ArrayList<Character> characters;
    private ArrayList<Enemy> enemies;

    public Level(){
        this.ground = new ArrayList<IItemManager>();
        this.characters = new ArrayList<Character>();

    }

    public Level(ArrayList<IItemManager> ground, ArrayList<Character> characters, ArrayList<Enemy> enemies) {
        this.ground = new ArrayList<IItemManager>();
        this.characters = characters;
        this.enemies = enemies;
    }

    public int getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
    }

    public  int getEnemyNum() {
        return enemyNum;
    }

    public void setEnemyNum(int enemyNum) {
        this.enemyNum = enemyNum;
    }

    public ArrayList<IItemManager> getGround() {
        return ground;
    }

    public void setGround(ArrayList<IItemManager> ground) {
        this.ground = ground;
    }


    public ArrayList<IItemManager> getAllItems() {
        return allItems;
    }

    public void setAllItems(ArrayList<IItemManager> allItem) {
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

    public void addCharacter(Character character){
        characters.add(character);
    }

    public void removeCharacter(Character character){
        characters.remove(character);
    }






    public Character selectChar(String[] userInput){
        for(Character character: characters){
            if (character.getName().equals(userInput[0])&& characters.indexOf(character)<4){
                return character;
            }
        }

        return null;

    }

    public Character selectTarget(String[] userInput){
        for (Character target:characters){
            if (target.getName().equals(userInput[2])){
                return target;
            }
        }

        return null;

    }

    public void death(){

    }

    public IItemManager selectItem(String[] userInput, Character selectedCharacter){
        ArrayList<IItemManager> tempList = new ArrayList<IItemManager>();
        tempList.addAll(ground);
        tempList.addAll(selectedCharacter.getInventory());
        tempList.add(selectedCharacter.getWeapon());
        tempList.add(selectedCharacter.getClothing());
        for (IItemManager item: tempList){


            try {
                if (item.getName().equals(userInput[2])) {
                    return item;
                }
            }catch (NullPointerException ignored){

            }


        }

        return null;
    }


    public IItemManager selectRandomItem() {
        SecureRandom secureRandom = new SecureRandom();

        int randomNum = secureRandom.nextInt(allItems.size());
        for (IItemManager item : allItems) {
            if(randomNum == allItems.indexOf(item)&& item instanceof Sword){
                return item;
            }

        }
        return null;



    }
    public void generateEnemy(){
        enemyNum = (int)Math.pow(2,levelNum);
        for (int i = 1; i <= enemyNum; i++) {
            Character enemy = new Enemy(allItems);
            enemy.setName("Enemy"+i);
            characters.add(enemy);


        }
    }





    public void display(){
        System.out.print("\nCreating Level "+levelNum+", with "+enemyNum+" enemy soldiers.\nEntering level "+enemyNum+ "; ");
        for (Character character: characters){
            if (character.getState() == 2){
                System.out.print(character.getName()+" enters.");
            }
        }
        System.out.println();

    }

    public void addItems(){


    }



    public void groundAdd(IItemManager item){
        ground.add(item);
    }

    public void groundRemove(IItemManager item){
        ground.remove(item);
    }

    public void allItemsAdd(IItemManager item){
        allItems.add(item);
    }

    public void allItemsRemove(IItemManager item){
        allItems.remove(item);
    }









}
