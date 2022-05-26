package Character;

import Item.Item;
import Item.Weapon;

import java.util.ArrayList;

public interface CharActions {
    public void attack(Character character);
    public Weapon selectRandomItem(ArrayList<Item> Inventory);

}
