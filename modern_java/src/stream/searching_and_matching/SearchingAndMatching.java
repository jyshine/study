package stream.searching_and_matching;

import stream.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SearchingAndMatching {
    static List<Dish> menu = Arrays.asList(
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

    /**
     *
     * 특정 속성이 데이터 집합에 있는지 여부를 검색하는 데이터 처리
     * allMatch, anyMatch, noneMatch, findFirst, findAny 등 다양한 유틸리티 메서드를 제공한다.
     *
     * allMatch, anyMatch, noneMatch 쇼트서킷 기법 즉 자바의 && ||와 같은 연산을 활용
     */

    public static void main(String[] args) {
        /**
         * 적어도 한 요소와 일치하는지 확인할 때 anyMatch
         */
        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("This menu is (somewhat) vegetarian friendly !!");
        }

        /**
         * allMatch 메서드는 anyMatch와 달리 스트림의 모든 요소가 주어진 프레디케이트와 일치하는지 검사합니다.
         */
        boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories() < 10000);
        System.out.println(isHealthy);

        /**
         * noneMatch는 allMatch와 반대 연산을 수행
         */
        boolean isHealthy2 = menu.stream().noneMatch(dish -> dish.getCalories() >= 10000);
        System.out.println(isHealthy2);

        /**
         * findAny 메서드는 현재 스트림에서 임의의 요소를 반환
         */
        Optional<Dish> anyDish = menu.stream().filter(Dish::isVegetarian).findAny();
        System.out.println(anyDish.toString());

        /**
         * findFirst 첫번째 요소 찾기
         */
        List<Integer> intCollect = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> first = intCollect.stream().map(number -> number * number).filter(num -> num % 3 == 0).findFirst();
        System.out.println(first.get());

    }
}
