package Item;



public class Clothing extends Item {
    private int endurance;

    public Clothing(String name,int tier,int weight,int endurance){
        super(name,weight);
        this.endurance = endurance;
    }


    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }




}
