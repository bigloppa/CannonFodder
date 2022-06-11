import java.util.ArrayList;

public class Clothing extends ItemFields implements Displayable,Item {
    private int resistance;

    public Clothing(){
        weight = 0;
    }

    public Clothing(String name,int weight,int resistance) {
        this.name = name;
        this.weight = weight;
        this.resistance = resistance;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {

        this.resistance = resistance;
    }


    @Override
    public void display() {
        System.out.println(getName() + " has "+ getResistance()+" resistance, and "+getWeight()+ " units of weight.");
    }


    @Override
    public Item generateItem(ArrayList<Item> items) {
        return null;
    }

}
