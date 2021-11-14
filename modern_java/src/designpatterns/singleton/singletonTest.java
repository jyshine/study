package designpatterns.singleton;

public class singletonTest {
    public static void main(String[] args) {
        // 1.private 생성자로 생성 후 static으로 인스턴스 생성하여 getInstance 매소드 생성
        Singleton1 singleton11 = Singleton1.getInstance();
        Singleton1 singleton12 = Singleton1.getInstance();
        System.out.println(singleton11 == singleton12);
        // 멀티 쓰레드 환경에서 동기화 처리가 안될 수 있음

        // 2.synchronized 키워드 사용
        Singleton2 singleton21 = Singleton2.getInstance();
        Singleton2 singleton22 = Singleton2.getInstance();
        System.out.println(singleton21 == singleton22);
        // 성능의 문제

        // 3.이른 초기화 (eager initialization)
        Singleton3 singleton31 = Singleton3.getInstance();
        Singleton3 singleton32 = Singleton3.getInstance();
        System.out.println(singleton31 == singleton32);
        // 미리 만든다는 단점이 있음 리소스 낭비

        // 4.double checked locking 사용 (생성할 때만 동기화 처리해줌) volatile
        Singleton4 singleton41 = Singleton4.getInstance();
        Singleton4 singleton42 = Singleton4.getInstance();
        System.out.println(singleton41 == singleton42);
        // 코드가 복잡하다

        // 5.static inner 클래스 사용하기
        Singleton5 singleton51 = Singleton5.getInstance();
        Singleton5 singleton52 = Singleton5.getInstance();
        System.out.println(singleton51 == singleton52);
        // 리플렉션을 사용하면 Singleton이 깨진다
        // 직렬화 & 역직렬화 사용하기로 깨진다. (대응가능)

        // 6.Enum 사용
        Singleton6Enum singleton6Enum1 = Singleton6Enum.INSTANCE;
        Singleton6Enum singleton6Enum2 = Singleton6Enum.INSTANCE;
        System.out.println(singleton6Enum1 == singleton6Enum2);
        // 미리 만들어지고 상속받지 못한다.


    }
}
