package behavior_parameterization.test;

public class AppleRedAndHeavyPredicate implements ApplePredicate {

    @Override
    public boolean applePredicate(Apple apple) {
        return ColorEnum.RED.equals(apple.getColor())&& apple.getWeight() > 150;
    }
}
