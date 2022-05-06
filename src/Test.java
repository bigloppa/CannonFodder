
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Tank tank = new Tank();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> arrayList = new ArrayList<>();
        arrayList.add(new Sword("Excalibur",12,12,12));
        tank.setInventory(arrayList);

        String[] userInput = scanner.nextLine().split(" ");
        tank.wield(userInput);

        System.out.println(tank.getWeapon());

        System.out.println(arrayList.size());



    }
}
