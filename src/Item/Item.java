package Item;

public abstract class Item{
    private String name;
    private int tier;
    private int weight;


    public Item(){

    }

    public Item(String name, int weight) {
        this.name = name;

        this.weight = weight;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int value) {
        this.tier = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


}
