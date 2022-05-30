
import Item.*;
import Character.*;

import java.lang.Character;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ArrayList<Item> allItems = new ArrayList<Item>();
        Scanner scanner = new Scanner(System.in);
        allItems.add(new Wand("hoks",23,12));
        allItems.add(new Wand("123",22,12));
        allItems.add(new Sword("exca",22,12));
        allItems.add(new Sword("excalibi",22,12));
        allItems.add(new Shield("shielee",22,12));
        allItems.add(new Shield("shieleelessdd",22,12));

        Healer healer = new Healer(allItems);
        Tank tank = new Tank(allItems);
        Fighter fighter = new Fighter(allItems);


        String[] user = scanner.nextLine().split(" ");

        fighter.wield(allItems,user);

        HardArmor hardArmor = new HardArmor("af",32,32,32);

        Wand wand = new Wand("23",34,12);



        hardArmor.display();
        wand.display();


        System.out.println(fighter.getWeapon().getName());
        System.out.println(healer.getWeapon().getName());
        System.out.println(tank.getWeapon().getName());


        System.out.println(fighter.getWeapon().getAttackDmg());

        Item item = new Wand("123",23,23);
        allItems.add(item);

















    }
}
