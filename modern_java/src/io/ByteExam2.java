package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteExam2 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {

            fileInputStream = new FileInputStream("src/io/ByteExam1.java");
            fileOutputStream = new FileOutputStream("src/io/byte.txt");

            int readCount = -1;
            //1바이트처리가 아니라
            //512 바이트만큼 처리하기
            byte[] buffer = new byte[512];

            while ((readCount = fileInputStream.read(buffer)) != -1){
                //최대 512 바이트 만큼 읽음
                fileOutputStream.write(buffer,0,readCount);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
