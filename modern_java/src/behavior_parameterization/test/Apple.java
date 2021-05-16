package behavior_parameterization.test;

public class Apple {
    private ColorEnum color;
    int weight;

    public Apple(ColorEnum color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Apple() {
    }

    public Apple(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color=" + color +
                ", weight=" + weight +
                '}';
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }
}
