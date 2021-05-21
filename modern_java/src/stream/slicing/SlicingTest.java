package stream.slicing;

import stream.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SlicingTest {
    /**
     * 자바 9은 스트림의 요소를 효과적으로 선택할 수 있도록 takeWhile, dropWhile 두가지 새로운 메서드를 지원한다.
     *
     *
     */

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        List<Dish> filterMenu = menu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

//        List<Dish> filterMenu = menu.stream()
//                .takeWhile(dish -> dish.getCalories() < 320)
//                .collect(Collectors.toList());
//
//        List<Dish> filterMenu = menu.stream()
//                .dropWhile(dish -> dish.getCalories() < 320)
//                .collect(Collectors.toList());

    }
}
