public class Clothing extends Item{
    private int endurance;

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    @Override
    public void examine(){
        System.out.println("Item Name: "+getName());
        System.out.println("Item Type: "+getClass());
        System.out.println("Item Weight: "+getWeight());
        System.out.println("Item Tier: "+getTier());
        System.out.println("Item Endurance"+getEndurance());
    }


}
