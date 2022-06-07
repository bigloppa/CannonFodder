import java.util.ArrayList;

public interface Item extends Displayable {
    Item generateItem(ArrayList<Item>items);
     Item findItem(String name,ArrayList<Item>items);

}
