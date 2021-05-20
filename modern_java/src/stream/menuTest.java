package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class menuTest {

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


        List<String> threeHightCaloricDishNames = menu.stream() // <- menu에서 스트림을 얻는다.
                .filter(dish -> dish.getCalories() > 300) // <- 파이프라인 연산 만들기, 첫 번째로 고칼로리 요리를 필터링
                .map(Dish::getName) //요리명 추출
                .limit(3)   //선착순 세개만 선택
                .collect(Collectors.toList()); //결과를 다른 리스트로 저장
        System.out.println(threeHightCaloricDishNames); // 결과 출력



    }
}
