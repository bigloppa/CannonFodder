
import Item.*;
import Character.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ArrayList<Item>generaInv = new ArrayList<Item>();
        generaInv.add(new Sword("asd",23,23));
        generaInv.add(new Sword("exca",434,123));
        generaInv.add(new Wand());
        generaInv.add(new Shield());

        Fighter fighter = new Fighter(generaInv);

        System.out.println(fighter.getWeapon().getName());





    }
}
