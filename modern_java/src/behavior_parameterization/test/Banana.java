package behavior_parameterization.test;

public class Banana {
    private ColorEnum color;
    int weight;

    public Banana(ColorEnum color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Banana{" +
                "color=" + color +
                ", weight=" + weight +
                '}';
    }
}
