package thread;

public class ThreadTest1Exam {
    public static void main(String[] args) {
        ThreadTest1 threadTest1 = new ThreadTest1("*");
        ThreadTest1 threadTest2 = new ThreadTest1("-");

        // Thread 상속 받아 Override run을 했다.
        // 실행할 땐 run() 호출이 아니라 start()를 실행한다.


        threadTest1.start();
        threadTest2.start();
            try {
                for (int i = 0; i<100; i++) {
                    System.out.println("main : " + i);
                    Thread.sleep(4000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
