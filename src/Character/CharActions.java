package Character;

import Item.Item;
import Item.Weapon;

import java.util.ArrayList;

public interface CharActions {
     void attack(Character character);
     Weapon selectRandomItem(ArrayList<Item> Inventory);

}
