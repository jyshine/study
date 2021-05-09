package thread;

public class MusicBox {
    public void playMusicA() {

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(" 신나는 음악");
                Thread.sleep((int)(Math.random()*1000));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void playMusicB() {
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
                System.out.println(" 락 음악");
                Thread.sleep((int)(Math.random()*1000));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
