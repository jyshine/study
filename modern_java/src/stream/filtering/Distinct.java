package stream.filtering;

import java.util.Arrays;
import java.util.List;

public class Distinct {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0 )
                .distinct() //2,2,4
                .forEach( //2,4
                        System.out::println
                );
    }
}
