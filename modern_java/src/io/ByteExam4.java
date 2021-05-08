package io;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ByteExam4 {

    public static void main(String[] args) {

        //다양한 데이터 타입으로 읽기

        try (
                DataInputStream in = new DataInputStream(new FileInputStream("src/io/data.txt"))
                ) {
            //정수 먼저 읽기
            int i = in.readInt();
            boolean b = in.readBoolean();
            double d = in.readDouble();

            System.out.println(i);
            System.out.println(b);
            System.out.println(d);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
