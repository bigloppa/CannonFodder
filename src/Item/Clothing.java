package Item;



public class Clothing extends Item {
    private int resistance;

    public Clothing(String name,int tier,int weight,int endurance){
        super(name,weight);
        this.resistance = endurance;
    }


    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    @Override
    public void display() {
        System.out.println(getName() + " has"+ getResistance()+" resistance, and "+getWeight()+ " units of weight.");
    }
}
