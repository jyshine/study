package annotation;

import java.lang.reflect.Method;

public class HelloExam {
    public static void main(String[] args) {
        HelloAnnotation hello = new HelloAnnotation();
        hello.hello();

        // 메소드 정보 알아보기
        try {
            Method method = hello.getClass().getDeclaredMethod("hello");
            //getClass Object 메소드
            //getClass 해당 인스턴스 만들 때 클래스 정보
            //getDeclaredMethod 정보를 얻고 hello 라는 정보를 가져와라

            if(method.isAnnotationPresent(Count100.class)){
                //특정 메소드가 Annotaion을 적용되어 있는지 확인하는 기능
            }else {}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
