package io;

import java.io.*;

public class CharIOExam2 {

    //파일을 읽을려면 filereader
    //한줄씩 읽을려면 BufferdReader

    //파일쓰기는 file writer 사용


    public static void main(String[] args) {
        BufferedReader br = null;

        PrintWriter pw = null;
        try {
            br = new BufferedReader(new FileReader("src/io/CharIOExam2.java"));
            pw = new PrintWriter(new FileWriter("src/io/test.txt"));
            //최근엔 PrintWriter 만으로도 파일을 읽을 수 있다.

            String line = null;

            while((line = br.readLine()) != null){ // 파일이 끝 값이면 null을 반환한다.
                pw.println(line);
            }

            //close()를 안하면 입력이 안된다 항상 닫아줘라!

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.close();
        }
    }
}
