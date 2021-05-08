package basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set Test
 */
public class SetTest {
    public static void main(String[] args) {
        String[] array = {"aa", "bb", "cc", "cc"};
        Set<String> set1 = new HashSet<>(Arrays.asList(array));

        System.out.println(set1.add("dd"));
        System.out.println(set1.add("ee"));
        System.out.println(set1.add("ee"));

        System.out.println(set1);
        System.out.println(set1.size());

        Iterator itr = set1.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
