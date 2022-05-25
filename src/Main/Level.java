package Main;

import Item.Item;
import Character.*;
import  Character.Character;

import java.util.ArrayList;

public class Level {
    private ArrayList<Item> ground;
    private static int levelNum;
    private static int enemyNum;
    private ArrayList<Item> generalInv;
    private ArrayList<Character> characters;

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
        return generalInv;
    }

    public void setGeneralInv(ArrayList<Item> generalInv) {
        this.generalInv = generalInv;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }


    public static void main(String[] args) {
        System.out.println("CANNON FODDER");
        Fighter fighter = new Fighter();





    }
}
