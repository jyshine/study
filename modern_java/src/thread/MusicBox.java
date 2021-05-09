package thread;

public class MusicBox {

    public synchronized void playMusicA() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(" 신나는 음악");
                Thread.sleep((int)(Math.random()*1000));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void playMusicB() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(" 조용한 음악");
                Thread.sleep((int)(Math.random()*1000));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void playMusicC() {
        try {
            for (int i = 0; i < 10; i++) {
                //블록 부분만 synchronized로 처리할 수 있다.
                synchronized (this){
                    System.out.println(" 락 음악");
                }
                Thread.sleep((int)(Math.random()*1000));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
