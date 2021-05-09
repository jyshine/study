package thread;

public class ThreadTest2 implements Runnable{
    //자바는 단일 상속먼 지원하기 때문에 인터페이스로 구현한다.


    String str;

    public ThreadTest2(String str){
        this.str = str;
    }


    @Override
    public void run() {
        try {
            for(int i =0 ; i< 10; i++){
                System.out.println(str);
                    Thread.sleep((int)(Math.random()*1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
