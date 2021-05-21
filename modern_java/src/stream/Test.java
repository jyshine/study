package stream;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {

        int sum =0;
        for(int i : Arrays.asList(1,2,3,4,5,6,7,8)){
            sum += i;
        }

        System.out.println(sum);
    }
}
