
import Item.*;
import Character.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Tank tank = new Tank();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> arrayList = new ArrayList<>();


        arrayList.add(new Sword("Excalibur",12,12,12));
        tank.setInventory(new ArrayList<Item>());


        String[] userInput = scanner.nextLine().split(" ");

        tank.pick(userInput,arrayList);

        System.out.println(tank.getWeapon());
        tank.listInventory();

        System.out.println(arrayList.size());

        Clothing cloth = new Clothing("Med Armor",10,15,25);
        Weapon weapon = new Sword("Dark Sword",12,10,25);
        ArrayList<Item> arrayList1 = new ArrayList<>();
        Fighter fighter = new Fighter(weapon,cloth,arrayList1);




    }
}
