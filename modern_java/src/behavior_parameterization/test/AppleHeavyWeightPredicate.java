package behavior_parameterization.test;

public class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean applePredicate(Apple apple) {
        return apple.getWeight() > 150;
    }
}
