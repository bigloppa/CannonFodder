import java.util.ArrayList;

public interface Item extends Displayable {
    Item generateItem(ArrayList<Item>items);
    String getName();
    int getWeight();



}
