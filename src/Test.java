
import Item.*;
import Character.*;

import java.lang.Character;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ArrayList<Item> allItems = new ArrayList<Item>();
        allItems.add(new Wand("hoks",23,12));
        allItems.add(new Wand("123",22,12));
        allItems.add(new Sword("exca",22,12));
        allItems.add(new Sword("excalibi",22,12));
        allItems.add(new Shield("shielee",22,12));
        allItems.add(new Shield("shieleelessdd",22,12));

        Healer healer = new Healer(allItems);
        Tank tank = new Tank(allItems);
        Fighter fighter = new Fighter(allItems);


        System.out.println(fighter.getWeapon().getName());
        System.out.println(healer.getWeapon().getName());
        System.out.println(tank.getWeapon().getName());


        System.out.println(fighter.getWeapon().getAttackDmg());










    }
}
