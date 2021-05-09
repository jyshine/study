package thread;

public class ThreadDaemonTest implements Runnable{

    @Override
    public void run() {
        try {
            for (int i = 0; i< 10; i++){
                Thread.sleep(2000);
                System.out.println( i );
            }
        } catch (InterruptedException e) {
                e.printStackTrace();
        }


    }

    public static void main(String[] args) {

        Thread threadTest = new Thread(new ThreadDaemonTest());
        threadTest.setDaemon(true);
        threadTest.start();


        try {
            Thread.sleep(5000);
            System.out.println("메인 종료");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}