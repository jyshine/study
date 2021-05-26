package solution.globalnetworks;

import java.util.Arrays;
import java.util.List;

public class CodingTest {
    public static void main(String[] args) {
        int[] arr = {1,2,-1,4,5};
//        int[] number = {402,-1,1608,3216,6432};

        int answer = -1;  //숨겨진 원소의 값을 찾아서 저장하세요.

        int index = 0;

        for(int i=0; i<arr.length-1; i++){
            if(arr[i]== -1){
                index = i+1;
            }
        }

        if(arr[index]==arr[index+1]){
            answer = arr[index];
        }

        if(arr[index+1]-arr[index] ==arr[index+2]-arr[index+1] ){
            answer = arr[index]+(arr[index]-arr[index+1]);
        }else {
            answer = arr[index]/2;
        }

        System.out.println(answer);

    }
}
