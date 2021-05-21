package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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
                .collect(toList()); //결과를 다른 리스트로 저장
        //System.out.println(threeHightCaloricDishNames); // 결과 출력

        /* 데이터 소스는 menu다. 데이터 소스는 연속된 요소를 스트림에 제공한다.
            다음 으로 스트림에 filter, map, limit, collect로 이어지는 일련의 데이터 처리연산을 적용한다.
            collect를 제외한 모든 연산은 서로 파이프라인을 형성할 수 있도록 스트림을 반환한다.
            파이프라인은 소스에 적용하는 질의 같은 존재이다 마지막으로 collect 연산으로 파이프라인을 처리해서 결과 반환
        */


        List<String> names =
                menu.stream()
                        .filter(
                                dish -> {
                                    System.out.println("filtering : " + dish.getName());
                                    return dish.getCalories() > 300;
                                })
                        .map(
                                dish -> {
                                    System.out.println("mapping : " + dish.getName());
                                    return dish.getName();
                                })
                        .limit(3)
                        .collect(toList());
        System.out.println(names);
    }
}
