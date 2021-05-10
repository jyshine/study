package behavior_parameterization.test;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean applePredicate(Apple apple) {
        return ColorEnum.GREEN.equals(apple.getColor());
    }
}
