package basic;

public class MathTest {
    /**
     *  Math
     *  수학 계산
     *  cos
     *  sin
     *  tan
     *  abs
     *  random
     *  ...
     *
     *  생성자 private
     *  객체 생성할 수 없음.
     *
     *  메소드들이 static으로 구현되어 있어 사용 가능.
     */
    public static void main(String[] args) {
        //최댓값
        int value1 = Math.max(5, 30);
        System.out.println(value1);

        //최소값
        int value2 = Math.min(5, 30);
        System.out.println(value2);

        //절댓값
        System.out.println(Math.abs(-10));

        //랜덤
        System.out.println(Math.random());

        //제곱근
        System.out.println(Math.sqrt(25));

        System.out.println("2의 10승 = " + Math.pow(2, 10));
        System.out.println("16의 1/2승 = : " + Math.pow(16, 0.5));
        System.out.println("log200 = " + Math.log10(200));
    }
}
