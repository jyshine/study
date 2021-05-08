package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarIOExam1 {

    public static void main(String[] args) {
        //한줄씩 입력 받기 위해 BufferedReader 생성 필요하다
        //어디서 입력을 받을 것이냐 할 때 생성저에 Read 타입으로 넣어줘어야하는데
        //키보드에서 입력 받는 system.in은 read 타입이 아니기 때문에
        //InputStreamReader을 이용해서 입력 받는다.
        //데코레이터 패턴 => 객체에 추가적인 요건을 동적으로 첨가하는 방식 서브플래스를 만드는 것을 통해 유연하게 확장 방법 제공
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = null;

        try {
             line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(line);
    }
}
