package lambda;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "A", "B");
//        strings.sort((s1,s2) -> s1.compareToIgnoreCase(s2));
        strings.sort(String::compareToIgnoreCase);

        for(String val : strings){
            System.out.println(val);
        }
    }
}
