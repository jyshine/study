package solution.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 가장큰수 {

    static public String solution(int[] numbers) {
        String answer = "";

        for (int i=0; i< numbers.length; i++){
            for(int j=0; j<numbers.length;j++){
                System.out.println(i + " / "+ j);
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        String answer = solution(numbers);
        System.out.println(answer);
    }
}
