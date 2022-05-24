package Item;



public class Clothing extends Item {
    private int endurance;


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
