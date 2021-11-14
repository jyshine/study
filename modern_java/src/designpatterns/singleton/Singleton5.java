package designpatterns.singleton;

public class Singleton5 {
    private static Singleton5 instance;

    private Singleton5(){}

    private static class Singleton5Hold{
        private static final Singleton5 INSTANCE = new Singleton5();

        private static Singleton5 Singleton5Hold(){
            return INSTANCE;
        }
    }

    public static Singleton5 getInstance(){
        return Singleton5Hold.INSTANCE;
    }
}
