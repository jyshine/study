package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class ByteExam1 {

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("src/io/ByteExam1.java");
            fileOutputStream = new FileOutputStream("src/io/byte.txt");

            int readData = -1;

            while ((readData = fileInputStream.read()) != -1){
                fileOutputStream.write(readData);
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
    }
}
