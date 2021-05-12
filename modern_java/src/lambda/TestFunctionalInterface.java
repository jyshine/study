package lambda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class TestFunctionalInterface {

    /**
     * Consumer 테스트
     * @param list
     * @param c
     * @param <T>
     */
    static public <T> void forEachTest(List<T> list, Consumer<T> c){
        for (T v : list){
            c.accept(v);
        }
    }

    /**
     * Function 테스트
     * @param list
     * @param f
     * @param <T>
     * @param <R>
     * @return
     */
    static public <T,R> List<R> mapTest(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for(T t:list){
            result.add(f.apply(t));
        }
        return result;
    }



    public static void main(String[] args) {

        /** consumer **/
        forEachTest(Arrays.asList(1, 2, 3, 4, 5, 6),
                (Integer i)-> System.out.println(i)
                );

        /** function **/
        List<Integer> functionalTestResult = mapTest(Arrays.asList("lambda", "in", "action"),
                (String s) -> s.length()
        );
        System.out.println(functionalTestResult.toString());

    }
}
