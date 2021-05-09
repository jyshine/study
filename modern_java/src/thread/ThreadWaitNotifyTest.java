package thread;

public class ThreadWaitNotifyTest {
    public static void main(String[] args) {
        ThreadWaitNotify threadWaitNotify = new ThreadWaitNotify();
        // 앞에서 만든 쓰레드 threadWaitNotify 를 만든 후 start
        // 해당 쓰레드가 실행되면, 해당 쓰레드는 run 메소드 안에서 자신의 모니터링 락을 획득

        threadWaitNotify.start();
        // threadWaitNotify 에 대하여 동기화 블럭을 설정
        // 만약 main쓰레드가 아래의 블록을 위의 Thread보다 먼저 실행되었다면 wait를 하게 되면서 모니터링 락을 놓고 대기

        synchronized(threadWaitNotify){
            try{
                // b.wait()메소드를 호출.
                // 메인쓰레드는 정지
                // threadWaitNotify가 5번 값을 더한 후 notify를 호출하게 되면 wait에서 깨어남
                System.out.println("threadWaitNotify 가 완료될때까지 기다립니다.");
                threadWaitNotify.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            //깨어난 후 결과를 출력
            System.out.println("Total is: " + threadWaitNotify.total);
        }
    }
}
