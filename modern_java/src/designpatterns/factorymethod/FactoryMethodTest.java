package designpatterns.factorymethod;

public class FactoryMethodTest {
    public static void main(String[] args) {
        long supplyPrice = 13500;
        long salesRate = 20;
        System.out.println(supplyPrice);
        System.out.println(salesRate);
        System.out.println(((double) salesRate / 100));
        long supplyP = (long) (supplyPrice * ((double) salesRate / 100));
        System.out.println(supplyP);
    }
}
