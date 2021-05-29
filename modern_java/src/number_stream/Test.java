package number_stream;

import stream.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
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

        /**
         * 숫자 스트림으로 매핑
         */
        int calories = menu.stream()
            .mapToInt(Dish::getCalories)
            .sum();
        System.out.println(calories);

        /**
         * 객체 스트림으로 복원하기
         */

        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        /**
         * 숫자 범위
         */
        IntStream evenNumbers = IntStream.rangeClosed(1, 100) //1~100범위
                //1부터 100까지 짝수 스트림
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());

        /**
         * 피타고라스 수
         *
         * 두 수가 피타고라스 수의 일부가 될 수 잇는 좋은 조합인지 확인 방법
         * Math.sqrt(a*a+b*b) % 1 == 0;
         *
         * filter를 하면
         * filter(b -> Math.sqrt(a*a + b*b)  % 1 == 0)
         *
         * 세 번째 수를 찾기
         * stream.filter(b -> Math.sqrt(a*a + b*b)  % 1 == 0)
         * .map(b -> new int[]{a,b,(int) Math.sqrt(a*a+b*b)});
         */


    }
}
