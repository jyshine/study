package stream.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceTest {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 10);

        Integer reduce = arr.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce);

        int sum = arr.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        Optional<Integer> reduce1 = arr.stream().reduce(Integer::max);
        System.out.println(reduce1.get());

        Optional<Integer> reduce2 = arr.stream().reduce(Integer::min);
    }
}
