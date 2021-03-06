package lambda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

public class AroundPattern {

    /**
     * 현재 코드는 파일에서 한 번에 한줄만 읽을 수 있다.
     * 한 번에 두 줄을 읽거나 가장 자주 사용되는 단어를 반환하기 위해
     *
     * 기존의 설정, 정리 과정은 재사용하고 proessFile메서드만 다른 동작을 수행하도록
     * 명령할 수 있다면 좋을 것이다.
     * 즉 동작 파라미터 필요.
     *
     * @return
     * @throws IOException
     */
    public static String processFile() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("src/lambda/lambda"))){
            return br.readLine();
        }
    }

    public static String processFile2(BufferReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("src/lambda/lambda"))){
            return p.bufferReaderProcessor(br);
        }
    }


    public static void main(String[] args) {


        try {

            //String result = processFile(); // 한줄만 출력

            String result = processFile2((BufferedReader br) -> br.readLine() + br.readLine()); // 두줄 출력

            System.out.println(result);

            Function<BufferedReader,String> f = (BufferedReader b) -> {
                try{
                    return b.readLine();
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
            };


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
