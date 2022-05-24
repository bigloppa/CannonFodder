package Item;



public class Clothing extends Item {
    private int endurance;

    public Clothing(String name,int tier,int weight,int endurance){
        super(name,tier,weight);
        this.endurance = endurance;
    }


    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    @Override
    public void examine(){
        super.examine();


        System.out.println("Item Endurance"+getEndurance());
    }


}
