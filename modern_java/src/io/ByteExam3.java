package io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class ByteExam3 {

    //Java IO 객체는 인스턴스를 만들고 모두 사용하면 close() 메소드를 해워야한다.
    //try-with-resource
    //사용한 자원을 자동으로 종료 시켜주는 기능

    //다양한 타입의 저장

    public static void main(String[] args) {

        try(
                DataOutputStream out = new DataOutputStream(new FileOutputStream("src/io/data.txt"))
                ){

            out.writeInt(100);//4 byte
            out.writeBoolean(false); //1byte
            out.writeDouble(55.5); // 8 byte
            //data type으로 저장해서 값을 알아보기 힘들다.
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
