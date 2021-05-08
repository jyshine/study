package basic;
public class StringBufferExam {
    //메소드 체이닝 : 자기자신을 리턴하여 계속해서 자신의 메소드를 호출하는 방식

    public static void main(String[] args) {
        //String 불변

        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append(" ");
        sb.append("world !");

        String str = sb.toString();
        //System.out.println(str);
        String str2 = new StringBuffer().append("hello").append(" ").append("world !").toString();
        //System.out.println(str2);


        String str11 = "hello";
        String str22 = "world";
        String str33 = str11 + str22;
        System.out.println(str33);
        //해당 str11 + str22 연산 과정은 아래와 같다.
        String str44 = new StringBuffer().append(str11).append(str22).toString();
        System.out.println(str44);



        String str55 = "";
        for (int i = 0; i < 100; i++) {
            str55 = str55 + "*";
        }
        System.out.println(str55);
        //StringBuffer 객체가 반복 수 만큼 생성되서 성능이 좋지 않다.


        StringBuffer sb66 = new StringBuffer();
        for (int i = 0; i < 100; i++) {
            sb66.append("*");
        }
        String str66 = sb66.toString();
        System.out.println(str66);

        /**
         * 속도 체크 String
         */

        long startTime1 = System.currentTimeMillis();
        String strTest1 = "";
        for (int i = 0; i < 100000; i++) {
            strTest1 = strTest1 + "*";
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println(strTest1);

        /**
         * 속도 체크 StringBuffer
         */
        long startTime2 = System.currentTimeMillis();
        StringBuffer sbTest1 = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            sbTest1.append("*");
        }
        String strTest2 = sbTest1.toString();
        long endTime2 = System.currentTimeMillis();
        System.out.println(strTest2);

        long duration1 = endTime1-startTime1;
        long duration2 = endTime2-startTime2;

        System.out.println("String의 +연산을 이용한 경우 : "+ duration1);
        System.out.println("StringBuffer의 append()을 이용한 경우 : "+ duration2);

    }
}






