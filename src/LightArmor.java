public class LightArmor extends Clothing {
    int weight;
    int endurance;
    @Override
    public int getWeight() {
        return weight;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }


}
