package solution.globalnetworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {

        String input = "100 100";

        String[] split = input.split(" ");

        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        int count = 2;

    while (true){
        x = x -2;
        y = y -2;
        if(x < 0 || y < 0){
            break;
        }
        count++;
        if(x > y){
            y = y+3;
        }else {
            x = x+3;
        }
    }

        System.out.println(count);
    }
}
