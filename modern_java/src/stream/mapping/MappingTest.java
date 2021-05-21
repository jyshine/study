package stream.mapping;

import stream.Dish;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MappingTest {

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

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");

        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);

        /**
         * 스트림의 각 요소에 함수 적용하기
         * map
         */
        List<Integer> dishNameLenfths = menu.stream()
                .map(dish -> dish.getName())
                .map(String::length)
                .collect(toList());

        System.out.println(dishNameLenfths);

        /**
         * 스트림 평면화
         * flatMap
         */

        String[] words2 = {"Hello", "World"};

        Stream<String> streamOfwords = Arrays.stream(words2);

//        List<Stream<String>> collect = streamOfwords
//                .map(s -> s.split(""))
//                .map(Arrays::stream)
//                .distinct()
//                .collect(toList());

        //List<Stream<String>> 타임으로 반환되어 문제가 해결되지 않는다.
        List<String> collect1 = streamOfwords
                .map(s -> s.split("")) // 각 단어를 개별 문자를 포함하는 배열로 변환
                .flatMap(Arrays::stream)    // 생성된 스트림을 하나의 스트림으로 평면화
                .distinct()
                .collect(toList());

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> collect3 = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i+j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(toList());

        for(int[] val : collect3){
            System.out.println(Arrays.toString(val));
        }
    }



}
