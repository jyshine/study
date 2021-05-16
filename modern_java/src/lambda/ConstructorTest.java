package lambda;

import behavior_parameterization.test.Apple;
import behavior_parameterization.test.ColorEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorTest {


    public static List<Apple> mapConstructor(List<Integer> list, Function<Integer, Apple> f){
        List<Apple> result = new ArrayList<>();
        for (Integer i : list){
            result.add(f.apply(i));
        }
        return result;
    }

    public static void main(String[] args) {

        Supplier<Apple> c1 = () -> new Apple(ColorEnum.RED,140);
        System.out.println(c1.get().toString());

        Supplier<Apple> c2  = Apple::new;
        Apple a1 = c2.get();


        //Function<Integer, Apple> c3 = (weight) -> new Apple(weight);
        Function<Integer, Apple> c3 = Apple::new;
        Apple a2 = c3.apply(100);

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = mapConstructor(weights, Apple::new);

        //두 인수를 갖는 생성자는 BiFunction 인터페이스로와 같은 시그니처를 가지므로 다음처럼 수행
//        BiFunction<ColorEnum, Integer, Apple> c4 = ((color, weight) -> new Apple(color, weight));
        BiFunction<ColorEnum, Integer, Apple> c4 = Apple::new;
        Apple a3 = c4.apply(ColorEnum.GREEN, 100);
        System.out.println(a3.toString());



    }
}
