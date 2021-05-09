package thread;

public class ThreadTest2Exam {
    public static void main(String[] args) {
        ThreadTest2 threadTest1 = new ThreadTest2("*");
        ThreadTest2 threadTest2 = new ThreadTest2("-");

        //Thread class 를 상속 받았을 경우엔 Start를 사용햤지만
        //Implement 했을 경우 start()가 없고 run 밖에 없다.
        //그래서 Thread 객체를 생성하여 사용한다.


        Thread thread1 = new Thread(threadTest1);
        Thread thread2 = new Thread(threadTest2);

        thread1.start();
        thread2.start();

        try {
            for (int i = 0; i<100; i++) {
                System.out.println("main2 : " + i);
                Thread.sleep(4000);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
